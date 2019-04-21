package com.example.javaproject.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName:com.example.javaproject.proxy
 * Description:
 * author:wjc on 2019/4/20 17:35
 */
public class GamePlayerProxyCompany implements InvocationHandler {

    private Object factory;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    //通过 proxy 获取到动态代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        before();
        // 执行方法，第一个参数表示执行哪个对象的方法,剩下的参数是执行方法时需要传入的参数
        Object result = method.invoke(factory, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("proxy start");
    }

    private void after() {
        System.out.println("proxy end");
    }
}
