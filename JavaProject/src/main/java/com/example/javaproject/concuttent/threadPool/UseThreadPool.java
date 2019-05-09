package com.example.javaproject.concuttent.threadPool;

import com.example.javaproject.concuttent.Tools.SleepTool;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:com.example.javaproject.concuttent.threadPool
 * Description: jdk 线程池使用
 * author:wjc on 2019/5/8 08:03
 */
public class UseThreadPool {
    public static class WorkThread implements Runnable {
        private String name;
        Random mRandom = new Random();

        public WorkThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int time = mRandom.nextInt(100) * 5;
            SleepTool.ms(time);
//            System.out.println("name = " + name + ",time=" + time);
            System.out.println("current Thread="+Thread.currentThread().getName());
        }
    }

    public static class CallbackWorkThread implements Callable<String> {
        private String name;

        public CallbackWorkThread(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
//            System.out.println("callback work thread---");
            System.out.println("---current Thread="+Thread.currentThread().getName());
            return name;
        }
    }

    public static void main(String[] args) {
        // 核心线程数，最大线程数（包括核心），当任务数达到 corePoolSize 后，把任务添加到 BlockingQueue 阻塞队列中，
        // 当阻塞队列中也满了，那 maximumPoolSize 起作用，继续新建线程，达到 maximumPoolSize，如果还是满了，且没有空闲的工作线程，那 RejectExecutionHandler 将处理
        // new ThreadPoolExecutor.CallerRunsPolicy() 饱和策略，用调用者所在的线程执行，案例中调用者所在线程是 main 线程
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1,
                4, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(30)
                , new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 16; i++) {
            WorkThread workThread = new WorkThread("workThread-" + i);
            poolExecutor.execute(workThread);
        }
        for (int i = 0; i < 17; i++) {
            CallbackWorkThread callbackWorkThread = new CallbackWorkThread("callback work thread-" + i);
            FutureTask<String> task = new FutureTask<>(callbackWorkThread);
//            poolExecutor.execute(task);
            poolExecutor.submit(task);
            try {
//                System.out.println("result = " + task.get());
            } catch (Exception e) {
                Thread.interrupted();
                e.printStackTrace();
            }
        }
        poolExecutor.shutdown();
    }
}
