package com.example.wjc.myapplication.test_mode.test_Rx01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.wjc.myapplication.R;
import com.example.wjc.myapplication.Utils.LogUtils;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestDisposable;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestObservableOnSubscribe;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestObserver;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestScheduler;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RxJavaTest2Activity extends AppCompatActivity {
    private static final String TAG = "RxJavaTest2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_test2);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tv_test)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                TestObservable.create(new TestObservableOnSubscribe() {
                    @Override
                    public void subscribe() {

                    }
                }).subscribeOn(new TestScheduler() {
                    @Override
                    public TestWorker createWorker() {
                        return null;
                    }
                }).observeOn(new TestScheduler() {
                    @Override
                    public TestWorker createWorker() {
                        return null;
                    }
                }).subscribe(new TestObserver<String>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onSubscribe(TestDisposable d) {
                        LogUtils.i(TAG, "onSubscribe: ");
                    }
                });
                break;
            case R.id.tv_test2:
                Flowable.create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(FlowableEmitter<String> emitter) throws Exception {

                    }
                }, BackpressureStrategy.BUFFER).subscribe();
                break;
        }

    }

    public void testMap() {
        Observable.just("").map(new Function<String, Boolean>() {
            @Override
            public Boolean apply(String s) throws Exception {
                return false;
            }
        }).flatMap(new Function<Boolean, ObservableSource<String>>() {
                       @Override
                       public ObservableSource<String> apply(Boolean aBoolean) throws Exception {
                           return null;
                       }
                   }
        ).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        Observable.just("").flatMap(new Function<String, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(String s) throws Exception {
                return null;
            }
        });
    }
}
