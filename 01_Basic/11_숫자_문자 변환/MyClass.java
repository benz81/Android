package com.example.libtest1;

public class MyClass {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("Java");

        String s_i = "123";
        String s_f = "23.5";
        String s_d = "234.567";

        System.out.println(s_i + s_f + s_d);

        int i = Integer.valueOf(s_i).intValue();
        float f = Float.valueOf(s_f).floatValue();
        double d = Double.valueOf(s_d).doubleValue();

        System.out.println(i + f + d);

        int x = Integer.parseInt(s_i);
        float y = Float.parseFloat(s_f);
        double z = Double.parseDouble(s_d);

        System.out.println(x + y + z);

        System.out.println("x + y = " + x + y);
        System.out.println("x + y = " + (x + y));
        String str5 = String.valueOf(x);
        System.out.println(str5 + 1000);

        String str6 = Integer.toString(i);
        String str7 = Float.toString(f);
        String str8 = Double.toString(d);

        System.out.println("str6 = " + str6);
        System.out.println("str7 = " + str7);
        System.out.println("str8 = " + str8);

    }
}







