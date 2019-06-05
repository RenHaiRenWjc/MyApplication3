package com.example.javaproject.ObservaTest;

/**
 * ClassName:com.example.javaproject.ObservaTest
 * Description:
 * JcChen on 2019/6/4 22:30
 */
public class Client {
    public static void main(String[] args) {
        Observer a = new User("小A");
        Observer b = new User("小B");
        Observer c = new User("小C");
        Observable observable = new WeChatService();
        observable.add(a);
        observable.add(b);
        observable.add(c);
        observable.notifyMessage("将要下大雨啦，回家收衣服！");

        System.out.println("===========================================");
        java.util.Observer d = new User2("D");
        java.util.Observer e = new User2("E");
        java.util.Observable observable1=new WeChatService2();
        observable1.addObserver(d);
        observable1.addObserver(e);
        ((WeChatService2) observable1).notifyMsg("凛冬将至");

    }
}
