package com.example.wjc.myapplication.test.interfaceImp;

import android.icu.util.TimeUnit;

import com.example.wjc.myapplication.test.interfaceImp.TestDisposable;

/**
 * ClassName:com.example.wjc.myapplication.test
 * Description:调度器接口
 * JcChen on 2019/6/22 11:50
 */
public interface TestScheduler {

    public abstract TestWorker createWorker();

    public abstract static class TestWorker implements TestDisposable {
        public abstract TestDisposable schedule(Runnable run, long delay, TimeUnit unit);
        public abstract TestDisposable schedule(Runnable run);
    }
}
