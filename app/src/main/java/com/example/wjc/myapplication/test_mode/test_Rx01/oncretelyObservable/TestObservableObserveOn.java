package com.example.wjc.myapplication.test_mode.test_Rx01.oncretelyObservable;

import com.example.wjc.myapplication.Utils.LogUtils;
import com.example.wjc.myapplication.test_mode.test_Rx01.TestAbstractObservableWithUpstream;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestDisposable;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestObservableSource;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestObserver;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestScheduler;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.SimpleQueue;

/**
 * ClassName:com.example.wjc.myapplication.test
 * Description:ObserveOn---具体被观察者，将它之前的被观察者，包装成已经切换的被观察者
 * JcChen on 2019/6/22 9:52
 */
public class TestObservableObserveOn<T> extends TestAbstractObservableWithUpstream<T> {

    private static final String TAG = "TestObservableObserveOn";

    TestScheduler scheduler;

    public TestObservableObserveOn(TestObservableSource source, TestScheduler scheduler) {
        super(source);//source 调用 ObserveOn 的具体被观察者
        this.scheduler = scheduler;
    }

    /**
     *
     * @param observer 具体观察者
     */
    @Override
    protected void subscribeActual(TestObserver observer) {
        TestScheduler.TestWorker w = scheduler.createWorker();

        source.subscribe(new TestObserveOnObserver<T>(observer, w));//触发 source 的订阅方法
        LogUtils.i(TAG, "subscribeActual: ");
    }



    final static class TestObserveOnObserver<T> implements TestObserver<T>, Runnable, TestDisposable {


        TestObserver<? super T> downstream;
        TestScheduler.TestWorker worker;


        SimpleQueue<T> queue;

        Disposable upstream;

        Throwable error;
        volatile boolean done;

        volatile boolean disposed;

        int sourceMode;

        boolean outputFused;
        boolean delayError;

        public TestObserveOnObserver(TestObserver<? super T> downstream, TestScheduler.TestWorker worker) {
            this.downstream = downstream;
            this.worker = worker;
        }

        TestObserveOnObserver() {
        }

        @Override
        public void onSubscribe(TestDisposable d) {
            downstream.onSubscribe(this);
        }

        @Override
        public void onNext(T t) {
            schedule();
        }

        @Override
        public void onError(Throwable t) {
            schedule();
        }

        @Override
        public void onComplete() {
            schedule();
        }

        @Override
        public void dispose() {
            if (!disposed) {
                disposed = true;
                upstream.dispose();
                worker.dispose();
            }
        }

        @Override
        public boolean isDisposed() {
            return disposed;
        }

        void schedule() {
            worker.schedule(this);
        }

        void drainNormal() {
            int missed = 1;

            final SimpleQueue<T> q = queue;
            final TestObserver<? super T> a = downstream;

            for (; ; ) {
                if (checkTerminated(done, q.isEmpty(), a)) {
                    return;
                }

                for (; ; ) {
                    boolean d = done;
                    T v;

                    try {
                        v = q.poll();
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        disposed = true;
                        upstream.dispose();
                        q.clear();
                        a.onError(ex);
                        worker.dispose();
                        return;
                    }
                    boolean empty = v == null;

                    if (checkTerminated(d, empty, a)) {
                        return;
                    }

                    if (empty) {
                        break;
                    }

                    a.onNext(v);
                }

//                missed = addAndGet(-missed);
//                if (missed == 0) {
//                    break;
//                }
            }
        }

        void drainFused() {
            int missed = 1;

            for (; ; ) {
                if (disposed) {
                    return;
                }

                boolean d = done;
                Throwable ex = error;

                if (!delayError && d && ex != null) {
                    disposed = true;
                    downstream.onError(error);
                    worker.dispose();
                    return;
                }

                downstream.onNext(null);

                if (d) {
                    disposed = true;
                    ex = error;
                    if (ex != null) {
                        downstream.onError(ex);
                    } else {
                        downstream.onComplete();
                    }
                    worker.dispose();
                    return;
                }
            }
        }

        @Override
        public void run() {
            if (outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        boolean checkTerminated(boolean d, boolean empty, TestObserver<? super T> a) {
            if (disposed) {
                queue.clear();
                return true;
            }
            if (d) {
                Throwable e = error;
                if (delayError) {
                    if (empty) {
                        disposed = true;
                        if (e != null) {
                            a.onError(e);
                        } else {
                            a.onComplete();
                        }
                        worker.dispose();
                        return true;
                    }
                } else {
                    if (e != null) {
                        disposed = true;
                        queue.clear();
                        a.onError(e);
                        worker.dispose();
                        return true;
                    } else if (empty) {
                        disposed = true;
                        a.onComplete();
                        worker.dispose();
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
