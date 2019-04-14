package com.example.javaproject.reflection;

/**
 * ClassName:com.example.javaproject.reflection
 * Description: 类加载器
 * author:wjc on 2019/4/13 21:32
 */
public class TestClassLoader {
    public static void testClassLoader() throws ClassNotFoundException {

        //获取系统类加载器（可以获取，类（testReflection）就是它加载的） ）
        ClassLoader mClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(mClassLoader);

        // 获取系统加载类的父加载器（扩展类加载器，可以获取）
        mClassLoader = mClassLoader.getParent();
        System.out.println(mClassLoader);

        // 获取扩展类的父加载器（引导加载器，不可以获取）
        mClassLoader = mClassLoader.getParent();
        System.out.println(mClassLoader);

        //测试当前类是由哪个类加载器进行加载的----系统类加载器
        mClassLoader = Class.forName("com.example.javaproject.reflection.TestReflection").getClassLoader();
        System.out.println(mClassLoader);

        //测试 jdk 提供的 Object 是由哪个类加载器 加载的---引导类
        mClassLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(mClassLoader);

    }
}
