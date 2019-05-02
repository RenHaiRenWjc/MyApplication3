package com.example.javaproject.concuttent.safeEnd;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:com.example.javaproject.concuttent.safeEnd
 * Description:InterruptedException 后终止线程
 * author:wjc on 2019/4/30 08:33
 */
public class HasInterrputException {
    private static SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS");

    public static class UserThread extends Thread {
        @Override
        public void run() {
            super.run();
            String name = Thread.currentThread().getName();
            while (!isInterrupted()) {
                try {
                    System.out.println("start " + formatData.format(new Date()));
                    Thread.sleep(3000);
                } catch (InterruptedException e) {//中断回调，线程的控制权交给 cash 来处理
                    e.printStackTrace();
                    System.out.println("crash ,flag=" + isInterrupted() + ",at " + (formatData.format(new Date())));
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println("name=" + name);
            }
            System.out.println("end name=" + name + ", flag=" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserThread endThread = new UserThread();
        endThread.start();
        Thread.sleep(10);
        System.out.println("Main begin interrupt thread:" + formatData.format(new Date()));
        endThread.interrupt();
    }
}
