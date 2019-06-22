package com.example.wjc.myapplication.test;

import com.example.wjc.myapplication.Utils.LogUtils;
import com.example.wjc.myapplication.test.interfaceImp.TestObservableOnSubscribe;
import com.example.wjc.myapplication.test.interfaceImp.TestObserver;

/**
 * ClassName:com.example.wjc.myapplication.test
 * Description:
 * JcChen on 2019/6/22 9:42
 */
public class TestObservableCreate<T> extends TestObservable {
    private static final String TAG = "TestObservableCreate";
    TestObservableOnSubscribe source;

    public TestObservableCreate(TestObservableOnSubscribe source) {
        LogUtils.i(TAG, "TestObservableCreate: this=" + this);
        this.source = source;
    }


    @Override
    protected void subscribeActual(TestObserver observer) {

    }
}
