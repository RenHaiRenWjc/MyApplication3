package com.example.javaproject.proxy;

/**
 * ClassName:com.example.javaproject.proxy
 * Description:
 * author:wjc on 2019/4/14 19:45
 */
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer mGamePlayer;


    //构造器传入对谁代练
    public GamePlayerProxy(IGamePlayer gamePlayer) {
        System.out.println("hi,welcome to proxy");
        mGamePlayer = gamePlayer;
    }

    @Override
    public void login(String user, String pwd) {
        before();
        this.mGamePlayer.login(user, pwd);
    }

    @Override
    public void killBoss() {
        this.mGamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.mGamePlayer.upgrade();
        after();
    }

    private void before() {
        System.out.println("proxy start");
    }

    private void after() {
        System.out.println("proxy end");
    }
}
