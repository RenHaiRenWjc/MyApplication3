package com.example.wjc.myapplication.test.interfaceImp;

/**
 * ClassName:com.example.wjc.myapplication.test
 * Description:
 * JcChen on 2019/6/22 9:56
 */
public interface TestObservableSource<T> {
    void subscribe(TestObserver<? super T> observer);
}
