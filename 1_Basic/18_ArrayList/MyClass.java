package com.example.libtest1;

import java.util.ArrayList;
import java.util.Iterator;

public class MyClass {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        // list :  [ "400", "Python", "Java", "ABC" ]
        System.out.println(list.size());
        list.add("400");
        list.add("Java");
        list.add("ABC");
        System.out.println(list.size());
        list.add(1, "Python");

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        // list :  [ "Python", "Java", "ABC" ]
        list.remove(0);
        System.out.println("-------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        list.remove("ABC");
        System.out.println("-------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        list.add("Hello");
        list.add("Bye");
        list.add("Welcome to this Java Class.");

        // 1. loop
        System.out.println("-------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        // 2. loop
        System.out.println("----------------------");
        Iterator<String> i = list.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        // 3. loop
        System.out.println("----------------------");
        for(String value : list){
            System.out.println(value);
        }



    }
}







