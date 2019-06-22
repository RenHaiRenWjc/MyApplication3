package com.example.wjc.myapplication.test;

import com.example.wjc.myapplication.Utils.LogUtils;
import com.example.wjc.myapplication.test.interfaceImp.TestObservableOnSubscribe;
import com.example.wjc.myapplication.test.interfaceImp.TestObservableSource;
import com.example.wjc.myapplication.test.interfaceImp.TestObserver;
import com.example.wjc.myapplication.test.interfaceImp.TestScheduler;
import com.example.wjc.myapplication.test.oncretelyObservable.TestObservableObserveOn;
import com.example.wjc.myapplication.test.oncretelyObservable.TestObservableSubscribeOn;

/**
 * ClassName:com.example.javaproject
 * Description:抽象被观察者
 * JcChen on 2019/6/22 9:38
 */
public abstract class TestObservable<T> implements TestObservableSource {
    private static final String TAG = "TestObservable";
    public static <T> TestObservable<T> create(TestObservableOnSubscribe source) {
        return new TestObservableCreate<T>(source);
    }

    public  TestObservable<T> observeOn(TestScheduler scheduler) {
        LogUtils.i(TAG, "observeOn:--this=" + this);
        return new TestObservableObserveOn(this,scheduler);
    }

    public final TestObservable<T> subscribeOn(TestScheduler scheduler) {
        return new TestObservableSubscribeOn<T>(this, scheduler);//this：具体被观察者
    }


    @Override
    public void subscribe(TestObserver observer) {
        subscribeActual(observer);
    }


    protected abstract void subscribeActual(TestObserver<? super T> observer);
}
