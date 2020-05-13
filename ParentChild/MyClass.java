package com.example.libtest1;

import java.awt.MenuBar;

public class MyClass {

    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.name = "Mike";
        p1.age = 50;
        p1.setMoney(1000000);
        p1.printParentInfo();
        int money = p1.getMoney();
        System.out.println(money);
        Child ch1 = new Child();
        ch1.name = "Paul";
        ch1.age = 20;
        ch1.setHobby("movie");
        ch1.printParentInfo();
        System.out.println();
        ch1.printInfo();

    }
}
