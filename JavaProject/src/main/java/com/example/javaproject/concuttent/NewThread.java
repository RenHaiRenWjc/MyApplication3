package com.example.javaproject.concuttent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName:com.example.javaproject.concuttent
 * Description:
 * author:wjc on 2019/4/27 10:42
 */
public class NewThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunable myRunable = new MyRunable();
        new Thread(myRunable).start();

        CallBackInfo callBackInfo = new CallBackInfo();
        FutureTask<String> futureTask = new FutureTask<>(callBackInfo);
        new Thread(futureTask).start();
//        futureTask.get();
        System.out.println(futureTask.get());

        FutureTask<String> futureTask1 = new FutureTask<>(myRunable, "result,myrunable");
        new Thread(futureTask1).start();
        System.out.println(futureTask1.get());

    }

    //扩展 Thread 类
    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("my thread");
        }
    }

    //实现 Runable 接口
    static class MyRunable implements Runnable {
        @Override
        public void run() {
            System.out.println("runable");
        }
    }

    // 实现 Callable 接口，有返回值
    static class CallBackInfo implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("callback");
            return "result";
        }
    }
}
