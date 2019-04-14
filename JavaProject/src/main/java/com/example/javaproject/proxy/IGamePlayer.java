package com.example.javaproject.proxy;

/**
 * ClassName:com.example.javaproject.proxy
 * Description:
 * author:wjc on 2019/4/14 19:14
 */
public interface IGamePlayer {

    // 登录
    public void login(String user, String pwd);

    // 杀怪
    public void killBoss();

    // 升级
    public void upgrade();
}
