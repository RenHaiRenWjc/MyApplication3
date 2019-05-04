package com.example.javaproject.concuttent.rwLocalDemo;

import com.example.javaproject.concuttent.Tools.SleepTool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ClassName:com.example.javaproject.concuttent.rwLocalDemo
 * Description:
 * author:wjc on 2019/5/4 10:51
 */
public class UseRwLock implements GoodsService {
    private GoodsInfo mGoodsInfo;

    public UseRwLock(GoodsInfo goodsInfo) {
        mGoodsInfo = goodsInfo;
    }

    private ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = mReadWriteLock.readLock();
    private Lock writeLock = mReadWriteLock.writeLock();

    @Override
    public GoodsInfo getGoodsInfo() {
        readLock.lock();
        try {
            SleepTool.ms(5);
            return this.mGoodsInfo;
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void setSaleNumber(int number) {
        writeLock.lock();
        try {
            SleepTool.ms(5);
            mGoodsInfo.changeNumber(number);
        } finally {
            writeLock.unlock();
        }
    }
}
