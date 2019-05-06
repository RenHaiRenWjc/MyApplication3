package com.example.javaproject.concuttent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:com.example.javaproject.concuttent.NotifyAndWait
 * Description:必须被 synchronized 包围
 * condition、await()、signal()、signalAll()
 * author:wjc on 2019/5/3 23:04
 */
public class ExpressCond {

    private int km;
    private String addrss;
    private Lock mLock = new ReentrantLock();
    private Condition kmCond = mLock.newCondition();
    private Condition addressCond = mLock.newCondition();

    public ExpressCond(int km, String addrss) {
        this.km = km;
        this.addrss = addrss;
    }

    public void setKm(int km) {
        mLock.lock();
        try {
            this.km = km;
            kmCond.signal();
        } finally {
            mLock.unlock();
        }
    }

    public void setAddrss(String addrss) {
        mLock.lock();
        try {
            this.addrss = addrss;
            addressCond.signal();
        } finally {
            mLock.unlock();
        }
    }

    public void waitKm() {
        mLock.lock();
        try {
            while (km < 100) {
                try {
                    kmCond.await();
                    System.out.println("---waitKm ,thread " + Thread.currentThread().getName() + ",km=" + km);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            mLock.unlock();
        }
        System.out.println("km 插入 db");
    }

    public void waitAddress() {
        mLock.lock();
        try {
            while ("gz".equals(addrss)) {
                try {
                    addressCond.await();//阻塞后，当notify后，再次执行
                    System.out.println("wait address , thread=" + Thread.currentThread().getName() + ",addrss=" + addrss);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            mLock.unlock();
        }
        System.out.println("address 插入 db");

    }

}
