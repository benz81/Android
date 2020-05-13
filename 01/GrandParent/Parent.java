package com.example.libtest1;

public class Parent extends GrandParent {

    protected String job;

    Parent(){
        System.out.println("Parent class");
    }
    void printParentInfo(){
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("job : " + job);
    }

}
