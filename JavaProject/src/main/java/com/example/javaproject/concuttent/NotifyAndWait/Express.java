package com.example.javaproject.concuttent.NotifyAndWait;

/**
 * ClassName:com.example.javaproject.concuttent.NotifyAndWait
 * Description:
 * author:wjc on 2019/5/3 23:04
 */
public class Express {

    private int km;
    private String addrss;

    public Express(int km, String addrss) {
        this.km = km;
        this.addrss = addrss;
    }

    public synchronized void setKm(int km) {
        this.km = km;
        notify();//只能通知一个
    }

    public synchronized void setAddrss(String addrss) {
        this.addrss = addrss;
        notifyAll();
    }

    public synchronized void waitKm() {
        while (km < 100) {
            try {
                wait();
                System.out.println("waitKm ,thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("km 插入 db");
    }

    public synchronized void waitAddress() {
        while ("gz".equals(addrss)) {
            try {
                wait();
                System.out.println("wait address , thread=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("address 插入 db");
    }

}
