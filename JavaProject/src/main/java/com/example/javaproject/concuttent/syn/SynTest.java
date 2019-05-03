package com.example.javaproject.concuttent.syn;

/**
 * ClassName:com.example.javaproject.concuttent.syn
 * Description:
 * author:wjc on 2019/5/3 10:30
 */
public class SynTest {
    private long count = 0;
    private Object obj = new Object();//作为一个锁

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void inCount() {
        synchronized (obj) {
            System.out.println("count=" + count);
            count++;
        }
    }

    public synchronized void inCount2() {
        System.out.println("count=" + count);
        count++;
    }

    public void inCount3() {
        synchronized (this) {
            System.out.println("count=" + count);
            count++;
        }
    }

    private static class Count extends Thread {
        private SynTest mSynTest;

        public Count(SynTest synTest) {
            this.mSynTest = synTest;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100; i++) {
                mSynTest.inCount2();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynTest mSynTest = new SynTest();
        Count mCount1 = new Count(mSynTest);
        Count mCount2 = new Count(mSynTest);
        mCount1.start();
        mCount2.start();
        Thread.sleep(50);
        System.out.println(mSynTest.count);
    }
}
