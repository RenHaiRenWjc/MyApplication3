package com.example.javaproject.concuttent;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:com.example.javaproject.concuttent
 * Description: join()
 * author:wjc on 2019/5/2 10:37
 */
public class UseJoin {

    static class JumpQueue implements Runnable {
        private Thread mThread;

        public JumpQueue(Thread thread) {
            mThread = thread;
        }

        @Override
        public void run() {
            try {
                System.out.println(mThread.getName() + " will be join  " + Thread.currentThread().getName());
                mThread.join();
            } catch (InterruptedException e) {
                mThread.interrupt();
                e.printStackTrace();
            }
            System.out.println("after name=" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }


        TimeUnit.SECONDS.sleep(2);
        System.out.println("----after name=" + Thread.currentThread().getName());

    }
}
