package com.example.javaproject.ObservaTest;

/**
 * ClassName:com.example.javaproject.ObservaTest
 * Description: 抽象被观察者
 * <p>
 * wjChen on 2019/6/4 22:17
 */
public interface Observable {
    void add(Observer observer);

    void remove(Observer observer);

    void notifyMessage(String msg);
}
