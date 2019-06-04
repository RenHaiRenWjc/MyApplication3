package com.example.javaproject.proxy;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/**
 * ClassName:com.example.javaproject.proxy
 * Description:
 * author:wjc on 2019/4/14 19:36
 */
public class Client {

    public static void main(String[] args) {
//        proxyTest1();
        proxyTest2();
    }

    private static void proxyTest2() {
        IGamePlayer factory = new GamePlayer();
        GamePlayerProxyCompany playerProxyCompany = new GamePlayerProxyCompany();
        playerProxyCompany.setFactory(factory);

        IGamePlayer player = (IGamePlayer) playerProxyCompany.getProxyInstance();
        player.login("wjc", "pwd");//玩家
//        player.killBoss();
//        player.upgrade();

        //查看代理类
        ProxyUtils.generateClassFile(factory.getClass(), player.getClass().getSimpleName());
        Method[] methods = factory.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        GamePlayer gamePlayer = new GamePlayer();
        WeakReference<GamePlayer> gamePlayerWeakReference=new WeakReference<>(gamePlayer);
        gamePlayer = null;// 干掉强引用，确保这个实例只有 gamePlayerSoftReference 的弱引用

    }

    private static void proxyTest1() {
        System.out.println("---- start game----");
        IGamePlayer player = new GamePlayer("wjchen");//玩家
        IGamePlayer proxy = new GamePlayerProxy(player);//代练者

        proxy.login("renhairen", "password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("---- end game----");
    }
}
