package com.example.libtest1;

public class MyClass {

    public static void main(String[] args) {
        GrandParent gp = new GrandParent();
        gp.name = "grand";
        gp.age = 80;
        gp.printInfo();
        System.out.println("------------------------");

        Parent p = new Parent();
        p.name = "parent";
        p.age = 50;
        p.job = "edu";
        p.printInfo();
        System.out.println("------------------------");

        Child c = new Child();
        c.name = "child";
        c.age = 20;
        c.job = "student";
        c.hobby = "drum";
        c.printInfo();
        System.out.println("------------------------");
    }
}
