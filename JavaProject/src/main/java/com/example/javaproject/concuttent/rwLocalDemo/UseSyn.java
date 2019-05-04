package com.example.javaproject.concuttent.rwLocalDemo;

import com.example.javaproject.concuttent.Tools.SleepTool;

/**
 * ClassName:com.example.javaproject.concuttent.rwLocalDemo
 * Description:内置锁实现商品服务类
 * author:wjc on 2019/5/4 09:43
 */
public class UseSyn implements GoodsService {
    GoodsInfo mGoodsInfo;

    public UseSyn(GoodsInfo goodsInfo) {
        System.out.println("goodsinfo=" + goodsInfo.toString());
        mGoodsInfo = goodsInfo;
    }

    @Override
    public synchronized GoodsInfo getGoodsInfo() {
        SleepTool.ms(5);
        return this.mGoodsInfo;
    }

    @Override
    public synchronized void setSaleNumber(int number) {
        SleepTool.ms(5);
        mGoodsInfo.changeNumber(number);
    }
}
