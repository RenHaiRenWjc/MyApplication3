package com.example.wjc.myapplication.test_mode.test_Rx01;

import com.example.wjc.myapplication.test_mode.test_Rx01.interfaceImp.TestObservableSource;

/**
 * ClassName:com.example.wjc.myapplication.test
 * Description:抽象被观察者，继承了TestObservable
 * JcChen on 2019/6/22 9:53
 */
public abstract class TestAbstractObservableWithUpstream<T> extends TestObservable {


    public final TestObservableSource source;

    public TestAbstractObservableWithUpstream(TestObservableSource source) {
        this.source = source;
    }


}
