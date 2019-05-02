package com.example.javaproject.concuttent.threadLocal;

/**
 * ClassName:com.example.javaproject.concuttent.threadLocal
 * Description:
 * author:wjc on 2019/5/2 14:16
 */
public class NoThreadLocal {
    //    static Integer count = new Integer(1);
    static int count = 1;

    public static class TestTask implements Runnable {
        private int id;

        public TestTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            count = count + id;
            System.out.println(Thread.currentThread().getName() + ",count=" + count);
        }
    }

    public void startThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestTask(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static void main(String[] args) {
        NoThreadLocal noThreadLocal = new NoThreadLocal();
        noThreadLocal.startThreadArray();
    }

}
