package com.example.javaproject.concuttent.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ClassName:com.example.javaproject.concuttent.threadPool
 * Description:自己线程池实现
 * author:wjc on 2019/5/6 21:40
 */
public class MyThreadPool {
    // 线程池中默认线程的个数为5
    private int coreSize = 5;
    // 队列默认任务个数为100
    private int maxThreadCount = 100;
    // 任务队列，作为一个缓冲
    private BlockingQueue<Runnable> taskQueue;
    // 工作线程组
    private WorkThread[] workTasks;

    private int workerNum;


    // 创建线程池
    public MyThreadPool(int workerNum, int taskCount) {


        if (workerNum <= 0) {
            workerNum = coreSize;
        }
        this.workerNum = workerNum;
        if (taskCount <= 0) {
            taskCount = maxThreadCount;
        }

        taskQueue = new ArrayBlockingQueue<>(taskCount);
        workTasks = new WorkThread[workerNum];
        for (int i = 0; i < workTasks.length; i++) {
            workTasks[i] = new WorkThread();
            workTasks[i].start();
        }

//        Runtime.getRuntime().availableProcessors(); //获取 cpu 核心数
    }

    // 执行任务,其实只是把任务加入任务队列，什么时候执行有线程池管理器决定
    public void execute(Runnable runnable) {
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    销毁线程池,该方法保证在所有任务都完成的情况下才销毁所有线程，否则等待任务完成才销毁
    public void destroy() {
        for (int i = 0; i < workTasks.length; i++) {
            workTasks[i].stopWork();
            workTasks[i] = null;
        }
        taskQueue.clear();
    }

    @Override
    public String toString() {
        return "workerNum=" + workerNum + ",taskQueue=" + taskQueue.size();
    }

    /**
     * 内部类，工作线程
     */
    private class WorkThread extends Thread {

        @Override
        public void run() {
            super.run();
            Runnable r;
            try {
                while (!isInterrupted()) {
                    r = taskQueue.take();
                    System.out.println(getId() + " run" + ",taskQueue size=" + taskQueue.size());
                    r.run();
                    r = null;//help gc
                }
            } catch (InterruptedException e) {
                interrupt();
                e.printStackTrace();
            }
        }

        public void stopWork() {
            interrupt();
        }
    }
}
