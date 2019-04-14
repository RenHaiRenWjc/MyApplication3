package com.example.javaproject.reflection;

/**
 * ClassName:com.example.javaproject.reflection
 * Description:
 * author:wjc on 2019/4/13 21:25
 */
public class FootballTeam {
    String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public FootballTeam() {
        super();
    }

    public FootballTeam(String name, int number) {
        this.name = name;
        this.number = number;
    }

    private void privateMethod() {
        System.out.println("private method");
    }
}
