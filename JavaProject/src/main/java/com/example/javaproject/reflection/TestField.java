package com.example.javaproject.reflection;

import java.lang.reflect.Field;

/**
 * ClassName:com.example.javaproject.reflection
 * Description: 域相关
 * author:wjc on 2019/4/13 23:19
 */
public class TestField {
    public static void testField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        String className = "com.example.javaproject.reflection.FootballTeam";
        Class<FootballTeam> teamClass = (Class<FootballTeam>) Class.forName(className);

        System.out.println("get all field include public and private,but cannot get supper class field");
        Field[] fields = teamClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("---------------------------------");

        System.out.println("Get the specified field");
        Field field = teamClass.getDeclaredField("name");
        System.out.println(field.getName());

        FootballTeam footballTeam = new FootballTeam("GZFC", 18);
        System.out.println("Get the specified field value");
        Object obj = field.get(footballTeam);
        System.out.println(field.getName() + " = " + obj);

        System.out.println("set the specified Object field value");
        field.set(footballTeam, "guangzhou");
        System.out.println(field.getName() + " = " + footballTeam.getName());

        //字段是私有的，不管是写入还是读取，都必须先调用 setAccessible(true)方法
        field = teamClass.getDeclaredField("number");
        field.setAccessible(true);
        System.out.println(field.get(footballTeam));

    }
}
