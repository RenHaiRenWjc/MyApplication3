package com.example.javaproject.reflection;

import java.lang.reflect.Method;

/**
 * ClassName:com.example.javaproject.reflection
 * Description:
 * author:wjc on 2019/4/13 23:56
 */
public class TestMethod {

    public static void testMethod() throws Exception {
        String className = "com.example.javaproject.reflection.FootballTeam";
        Class<FootballTeam> teamClass = (Class<FootballTeam>) Class.forName(className);

        // 获取clazz对应类中的所有方法,不能获取private方法,且获取从父类继承来的所有方法
        Method[] methods = teamClass.getMethods();
        for (Method method : methods) {
            System.out.print(" " + method.getName() + "()");
        }
        System.out.println("---------------------------");

        // 获取所有方法，包括私有方法，所有声明的方法，都可以获取到，且只获取当前类的方法
        methods = teamClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(" " + method.getName() + "()");
        }
        System.out.println("---------------------------");

        // 获取指定的方法，需要参数名称和参数列表，无参则不需要写
        // 方法 public void setName(String name) {  }
        Method method = teamClass.getDeclaredMethod("setName", String.class);
        System.out.println(method);
        System.out.println("---");

        //  方法 public void setNumber(int number) {  }
        /* 这样写是获取不到的，如果方法的参数类型是int型
        如果方法用于反射，那么要么int类型写成Integer： public void setAge(Integer age) {  }
        要么获取方法的参数写成int.class*/
        method = teamClass.getDeclaredMethod("setNumber", int.class);
        System.out.println(method);
        System.out.println("---------------------------");

        // 执行方法，第一个参数表示执行哪个对象的方法,剩下的参数是执行方法时需要传入的参数
        Object obj = teamClass.newInstance();
        System.out.println("obj=" + obj);
        method.invoke(obj, 18);//setNumber(int num)

        // 私有方法的执行，必须在调用invoke之前加上一句method.setAccessible（true）;
        method = teamClass.getDeclaredMethod("privateMethod");
        System.out.println(method);

        System.out.println("---------------------------");
        System.out.println("执行私有方法");
        method.setAccessible(true);
        method.invoke(obj); //privateMethod()

        // Class.newInstance() 、Constructor.newInstance()

    }
}
