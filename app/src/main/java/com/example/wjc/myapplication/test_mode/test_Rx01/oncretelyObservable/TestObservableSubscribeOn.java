package com.example.wjc.myapplication.test_mode.test_Rx01.oncretelyObservable;

import com.example.wjc.myapplication.test_mode.test_Rx01.TestAbstractObservableWithUpstream;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestObservableSource;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestObserver;
import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestScheduler;

/**
 * ClassName:com.example.wjc.myapplication.test
 * Description:SubscribeOn
 * JcChen on 2019/6/22 11:58
 */
public class TestObservableSubscribeOn<T> extends TestAbstractObservableWithUpstream {
    public TestObservableSubscribeOn(TestObservableSource source, TestScheduler scheduler) {
        super(source);
    }

    @Override
    protected void subscribeActual(TestObserver observer) {

    }
}
