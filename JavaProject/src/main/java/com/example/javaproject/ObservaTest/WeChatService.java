package com.example.javaproject.ObservaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:com.example.javaproject.ObservaTest
 * Description: 具体被观察者，模拟微信服务端发信息
 * <p>
 * wjChen on 2019/6/4 22:20
 */
public class WeChatService implements Observable {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyMessage(String msg) {
        System.out.println("发布信息："+msg);
        for (Observer o : observerList) {
            o.update(msg);
        }
    }
}
