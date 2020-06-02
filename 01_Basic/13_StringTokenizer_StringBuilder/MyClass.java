package com.example.libtest1;

import java.util.StringTokenizer;

public class MyClass {

    public static void main(String[] args) {

        String text = "red/green/blue/white/black";
        StringTokenizer st = new StringTokenizer(text, "/");
        int countTokens = st.countTokens();
        System.out.println(countTokens);
        for(int i = 0; i < countTokens; i++){
            String token = st.nextToken();
            System.out.println(token);
        }

        StringTokenizer st2 = new StringTokenizer(text, "/");
        while(st2.hasMoreTokens()){
            String token = st2.nextToken();
            System.out.println(token);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Java ");
        sb.append("Programming Class");
        sb.append(" Bye");
        sb.insert(5, "language ");
        System.out.println(sb);

        sb.replace(0, 4, "Python");
        System.out.println(sb);

        System.out.println(sb.length());

        String str = sb.toString();


    }
}







