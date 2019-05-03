package com.example.javaproject.concuttent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:com.example.javaproject.concuttent
 * Description:
 * author:wjc on 2019/5/2 15:53
 */
public class LocalDemo {
    int count = 0;
    private Lock mLock = new ReentrantLock(true);

    private void incr() {
        mLock.lock();
        try {
            count++;
        } finally {
            mLock.unlock();
        }
    }

    public synchronized void incr2() {
        count++;
        incr2();
    }

    public static void main(String[] args) {
        LocalDemo localDemo = new LocalDemo();
    }
}
