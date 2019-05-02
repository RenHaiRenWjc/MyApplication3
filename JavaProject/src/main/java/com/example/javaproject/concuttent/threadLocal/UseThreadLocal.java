package com.example.javaproject.concuttent.threadLocal;

/**
 * ClassName:com.example.javaproject.concuttent.threadLocal
 * Description: ThreadLocal test
 * author:wjc on 2019/5/2 14:26
 */
public class UseThreadLocal {

    static ThreadLocal<Integer> sThreadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public static class TestTask implements Runnable {
        private int id;

        public TestTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            Integer count = sThreadLocal.get();
            count = count + id;
            sThreadLocal.set(count);
            System.out.println(Thread.currentThread().getName() + ",count=" + sThreadLocal.get());
        }
    }

    public void startThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new UseThreadLocal.TestTask(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static void main(String[] args) {
        UseThreadLocal useThreadLocal = new UseThreadLocal();
        useThreadLocal.startThreadArray();
    }
}
