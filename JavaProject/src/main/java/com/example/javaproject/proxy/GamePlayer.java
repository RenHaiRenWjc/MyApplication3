package com.example.javaproject.proxy;

/**
 * ClassName:com.example.javaproject.proxy
 * Description:
 * author:wjc on 2019/4/14 19:31
 */
public class GamePlayer implements IGamePlayer {

    private String nickName;

    public GamePlayer(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public void login(String user, String pwd) {
        System.out.println("user name=" + user + ",pwd=" + pwd);
    }

    @Override
    public void killBoss() {
        System.out.println("killBoss ....");
    }

    @Override
    public void upgrade() {
        System.out.println("oh,yes upgrade ....");
    }
}
