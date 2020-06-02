package com.example.libtest1;

import java.util.StringTokenizer;

public class MyClass {

    public static void main(String[] args) {

        int v1 = Math.abs(-5);
        double v2 = Math.abs(-3243.234);
        float v3 = Math.abs(-23111.455f);
        long v4 = Math.abs(-324234L);

        System.out.println(v1 + ", " + v2 + ", " + v3 + ", " + v4);

        double a1 = Math.ceil(5.3);
        double a2 = Math.ceil(-5.3);
        System.out.println(a1);
        System.out.println(a2);

        double a3 = Math.floor(5.7);
        double a4 = Math.floor(-5.7);
        System.out.println(a3);
        System.out.println(a4);

        int b1 = Math.max(1, 10);
        System.out.println(b1);

        int b2 = Math.min(-238,-224);
        System.out.println(b2);

        double c = Math.random();
        System.out.println(c);

        c = Math.random()*10;
        System.out.println(c);

        c = Math.random()*100;
        System.out.println(c);

        long v14 = Math.round(5.6);
        long v15 = Math.round(5.1);
        System.out.println(v14);
        System.out.println(v15);

        //  0 <= Math.random()       < 1
        //  0 <= Math.random() * 6   < 6
        //  0 <= 0,1,2,3,4,5 < 6
        //  1 <= 1,2,3,4,5,6 < 7
        int num = (int)(Math.random() * 45) + 1 ;
        System.out.println(num);

        

    }
}







