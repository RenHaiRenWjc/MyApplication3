package com.example.javaproject.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName:com.example.javaproject.reflection
 * Description:构造器相关
 * author:wjc on 2019/4/13 22:35
 */
public class TestConstructor {
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = "com.example.javaproject.reflection.FootballTeam";
        Class<FootballTeam> teamClass = (Class<FootballTeam>) Class.forName(className);

        System.out.println("get all Constructor object, as follows:");
        Constructor<FootballTeam>[] constructors = (Constructor<FootballTeam>[]) teamClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("Get a Constructor object, need a list of parameters:");
        Constructor<FootballTeam> constructor = teamClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //调用构造器 newInstance() 创建对象
        FootballTeam footballTeam = constructor.newInstance("GZFC", 18);
//        constructor.newInstance();
        System.out.println(footballTeam.getName()+"---"+footballTeam);
        
        System.out.println("obj="+teamClass.newInstance());
    }
}
