package com.example.javaproject.ObservaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * ClassName:com.example.javaproject.ObservaTest
 * Description:
 * JcChen on 2019/6/4 22:38
 */
public class WeChatService2 extends Observable {

    public void notifyMsg(String msg) {
        System.out.println("发布：" + msg);
        setChanged();
        notifyObservers(msg);
    }
}
