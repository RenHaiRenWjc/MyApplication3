package com.example.javaproject.concuttent.rwLocalDemo;

/**
 * ClassName:com.example.javaproject.concuttent.rwLocalDemo
 * Description:
 * author:wjc on 2019/5/4 09:35
 */
public class GoodsInfo {
    private String name;
    private int storeNumber;//库存
    private int totalMonkey;//收入

    public GoodsInfo(String name, int storeNumber, int totalMonkey) {
        this.name = name;
        this.storeNumber = storeNumber;
        this.totalMonkey = totalMonkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public int getTotalMonkey() {
        return totalMonkey;
    }

    public void setTotalMonkey(int totalMonkey) {
        this.totalMonkey = totalMonkey;
    }

    public void changeNumber(int number) {
        this.storeNumber -= number;
        this.totalMonkey += number * 25;

    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "name='" + name + '\'' +
                ", storeNumber=" + storeNumber +
                ", totalMonkey=" + totalMonkey +
                '}';
    }
}
