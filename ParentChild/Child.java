package com.example.libtest1;

public class Child extends Parent {
    // String name;
    // int age;
    private String hobby;
    Child(){
        System.out.println("Child class init");
    }
    void printInfo(){
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("hobby : " + hobby);
    }
    String getHobby(){
        return hobby;
    }
    void setHobby(String hobby){
        this.hobby = hobby;
    }


}
