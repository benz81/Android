package com.example.libtest1;
public class Parent {
    public String name;
    protected int age;
    private int money;
    Parent(){
        System.out.println("Parent class init");
    }
    void printParentInfo(){
        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }
    int getMoney(){
        return money;
    }
    void setMoney(int money){
        this.money = money;
    }
}
