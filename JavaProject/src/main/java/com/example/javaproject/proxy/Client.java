package com.example.javaproject.proxy;

/**
 * ClassName:com.example.javaproject.proxy
 * Description:
 * author:wjc on 2019/4/14 19:36
 */
public class Client {

    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("wjchen");
        System.out.println("start game----");
        player.login("renhairen", "password");
        player.killBoss();
        player.upgrade();
        System.out.println("end game----大-");

    }
}
