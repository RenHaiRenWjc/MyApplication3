package com.example.javaproject.ObservaTest;

/**
 * ClassName:com.example.javaproject.ObservaTest
 * Description:具体观察者
 * JcChen on 2019/6/4 22:28
 */
public class User implements Observer {
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + "---收到信息：" + msg);
    }
}
