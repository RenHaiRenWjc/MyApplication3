package com.example.javaproject.ObservaTest;

import java.util.Observable;
import java.util.Observer;

/**
 * ClassName:com.example.javaproject.ObservaTest
 * Description:
 * JcChen on 2019/6/4 22:37
 */
public class User2 implements Observer {
    String name;

    public User2(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println(name + "---" + o);
    }
}
