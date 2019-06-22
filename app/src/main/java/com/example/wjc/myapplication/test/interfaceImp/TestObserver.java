package com.example.wjc.myapplication.test.interfaceImp;

/**
 * ClassName:com.example.wjc.myapplication.test
 * Description:
 * JcChen on 2019/6/22 11:48
 */
public interface TestObserver<T> {
    void onComplete();

    void onError(Throwable throwable);

    void onNext(T t);

    void onSubscribe(TestDisposable d);
}
