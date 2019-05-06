package com.example.javaproject.concuttent.threadPool;

import java.util.Random;

/**
 * ClassName:com.example.javaproject.concuttent.threadPool
 * Description:
 * author:wjc on 2019/5/6 22:17
 */
public class TestMyThreadPool {

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool threadPool=new MyThreadPool(3,0);
        threadPool.execute(new MyTask("taskA"));
        threadPool.execute(new MyTask("taskB"));
        threadPool.execute(new MyTask("taskC"));
        threadPool.execute(new MyTask("taskD"));
        threadPool.execute(new MyTask("taskE"));
        System.out.println(threadPool.toString());
        Thread.sleep(10000);
        threadPool.destroy();

    }

     static class MyTask implements Runnable {
        private String name;
        private Random mRandom = new Random();

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(mRandom.nextInt(1000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getId()
                        + " sleep interruptException:" + Thread.currentThread().isInterrupted());
            }
            System.out.println("任务" + name + "完成！");
        }
    }
}
