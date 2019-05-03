package com.example.javaproject.concuttent.syn;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:com.example.javaproject.concuttent.syn
 * Description:类锁、对象锁
 * author:wjc on 2019/5/3 09:42
 */
public class SynClzAndInst {

    //使用类锁的线程
    private static class SynClass extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("SynClass");
            try {
                synClass();
            } catch (InterruptedException e) {
                interrupt();
                e.printStackTrace();
            }
        }
    }

    //类锁 实际是锁类的 class 对象
    private static synchronized void synClass() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("synClass going...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("synClass end");
    }

    private static Object sObject = new Object();

    private void synStaticObj() throws InterruptedException {
        synchronized (sObject) {//类似类锁，sObject在全虚拟机只有一份
            TimeUnit.SECONDS.sleep(1);
            System.out.println("synClass going...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("synClass end");
        }
    }

    // 使用对象锁线程
    private static class SynObject implements Runnable {
        private SynClzAndInst mSynClzAndInst;

        public SynObject(SynClzAndInst synClzAndInst) {
            mSynClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("SynObject is goning..." + this.toString());
            try {
                mSynClzAndInst.instance();
            } catch (InterruptedException e) {
                Thread.interrupted();
                e.printStackTrace();
            }
        }
    }

    // 使用对象锁线程
    private static class SynObject2 implements Runnable {
        private SynClzAndInst mSynClzAndInst;

        public SynObject2(SynClzAndInst synClzAndInst) {
            mSynClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("SynObject2 is goning..." + this.toString());
            try {
                mSynClzAndInst.instance2();
            } catch (InterruptedException e) {
                Thread.interrupted();
                e.printStackTrace();
            }
        }
    }

    //锁对象
    private synchronized void instance() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("instance is goning..." + this.toString());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("instance is end..." + this.toString());
    }

    //锁对象
    private synchronized void instance2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("instance2 is goning..." + this.toString());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("instance2 is end..." + this.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        SynClzAndInst synClzAndInst = new SynClzAndInst();
        Thread thread1 = new Thread(new SynObject(synClzAndInst));

        SynClzAndInst synClzAndInst2 = new SynClzAndInst();
        Thread thread2 = new Thread(new SynObject2(synClzAndInst2));

        thread1.start();
        thread2.start();

        SynClass synClass = new SynClass();
        synClass.start();
        TimeUnit.SECONDS.sleep(1);

    }

}
