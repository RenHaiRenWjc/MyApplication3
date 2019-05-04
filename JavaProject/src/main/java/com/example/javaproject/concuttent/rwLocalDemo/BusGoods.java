package com.example.javaproject.concuttent.rwLocalDemo;

import com.example.javaproject.concuttent.Tools.SleepTool;

import java.util.Random;

/**
 * ClassName:com.example.javaproject.concuttent.rwLocalDemo
 * Description:
 * author:wjc on 2019/5/4 10:06
 */
public class BusGoods {

    public static class ReadThread implements Runnable {
        private GoodsService mGoodsService;

        public ReadThread(GoodsService goodsService) {
            mGoodsService = goodsService;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                mGoodsService.getGoodsInfo();
            }
            System.out.println("读取100件商品信息耗时：" + (System.currentTimeMillis() - start));
        }
    }

    public static class WriteThread implements Runnable {
        private GoodsService mGoodsService;

        public WriteThread(GoodsService goodsService) {
            mGoodsService = goodsService;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                SleepTool.ms(50);
                mGoodsService.setSaleNumber(random.nextInt(100));
            }
            System.out.println("写入10次商品信息耗时---：" + (System.currentTimeMillis() - start));
        }
    }

    public static void main(String[] args) {
        GoodsInfo goodsInfo = new GoodsInfo("cpu", 1000, 10);
        GoodsService goodsService = new UseSyn(goodsInfo);
//        GoodsService goodsService = new UseRwLock(goodsInfo);
        for (int i = 0; i < 3; i++) {
            Thread writeThread = new Thread(new WriteThread(goodsService));
            for (int j = 0; j < 10; j++) {
                Thread readThread = new Thread(new ReadThread(goodsService));
                readThread.start();
            }
            SleepTool.ms(100);
            writeThread.start();
        }
    }
}
