package com.example.javaproject.concuttent.notifyAndWait;

/**
 * ClassName:com.example.javaproject.concuttent.NotifyAndWait
 * Description: wait、notify、notifyAll
 * author:wjc on 2019/5/3 23:11
 */
public class NWTest {
   static Express express = new Express(0, "gz");

    private static class kmThread extends Thread{
        @Override
        public void run() {
            super.run();
            express.waitKm();
        }
    }

    private static class addressThread extends Thread{
        @Override
        public void run() {
            super.run();
            express.waitAddress();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new kmThread().start();
        }
        for (int i = 0; i < 3; i++) {
           new addressThread().start();
        }
        Thread.sleep(1000);
        express.setAddrss("fs");
        express.setKm(111);
    }

}
