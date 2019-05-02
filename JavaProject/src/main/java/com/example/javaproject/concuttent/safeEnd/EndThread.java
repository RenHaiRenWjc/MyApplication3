package com.example.javaproject.concuttent.safeEnd;

/**
 * ClassName:com.example.javaproject.concuttent.safeEnd
 * Description:终止线程
 * author:wjc on 2019/4/30 08:04
 */
public class EndThread extends Thread {
    public EndThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        String threadName = Thread.currentThread().getName();
        System.out.println("name=" + threadName + ",interrupt flag=" + isInterrupted());
//        while (!isInterrupted()) {  //10ms 后 isInterrupted() 变为 true，并且结束
        while (!Thread.interrupted()){ //10ms 后 isInterrupted() 变为 false,但已经结束
            System.out.println("name=" + threadName + ",inner,interrupt flag=" + isInterrupted());
        }
        System.out.println("name=" + threadName + ",end,interrupt flag=" + isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        EndThread endThread = new EndThread("myThread");
        endThread.start();

        Thread.sleep(10);
        endThread.interrupt();
    }
}
