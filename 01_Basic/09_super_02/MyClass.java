package com.example.libtest1;

public class MyClass {

    public static void main(String[] args) {
        ChildAirplane ca1 = new ChildAirplane();
        ca1.flyMode = 1;
        ca1.takeOff();
        ca1.fly();
        ca1.land();

        ca1.flyMode = 2;
        ca1.takeOff();
        ca1.fly();
        ca1.land();

    }
}
