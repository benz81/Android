package com.example.libtest1;

import java.util.ArrayList;
import java.util.HashMap;
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
        list.add("Hello");
        list.add("Hello");

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

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name" , "Mike");
        map.put("tel", "010-1234-5678");
        map.put("address", "Seoul");
        map.put("name", "Paul");
        map.put("name", "Harry");
        map.put("name", "Jane");
        map.put("age", "25");


        System.out.println(map.get("name"));
        System.out.println(map.get("tel"));
        System.out.println(map.get("address"));

        System.out.println("----------------");
        Object[] keys = map.keySet().toArray();
        for(int k =0; k <keys.length; k++){
            System.out.println( (String)keys[k]);
        }
        System.out.println("----------------");

        Object[] values = map.values().toArray();
        for(int k =0; k <values.length; k++){
            System.out.println( (String)values[k]);
        }
        System.out.println("----------------");

        // "KOR" , 88       "ENG", 77     "MATH" : 100
        HashMap<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("KOR", 88);
        scoreMap.put("ENG" , 77);
        scoreMap.put("MATH", 100);

        Object[] values2 = scoreMap.values().toArray();
        for(int k =0; k <values2.length; k++){
            System.out.println( (Integer) values2[k]);
        }
        System.out.println("----------------");
        // ArrayList
        // 46.33,   77.8 , 90.0 , 87.5
        ArrayList<Double> scoreList = new ArrayList<>();
        scoreList.add(46.33);
        scoreList.add(77.8);
        scoreList.add(90.0);
        scoreList.add(87.5);

        for(Double value : scoreList){
            System.out.println(value);
        }

        System.out.println("----------------");
        // "Mike" 46.33,  "Harry" 77.8 ,  "Jane" 90.0 , "Paul" 87.5
        HashMap<String, Double> nameMap = new HashMap<>();
        nameMap.put("Mike", 46.33);
        nameMap.put("Harry", 77.8);
        nameMap.put("Jane", 90.0);
        nameMap.put("Paul", 87.5);

        System.out.println(nameMap.get("Jane"));

        nameMap.remove("Jane");

        System.out.println(nameMap.get("Jane"));
    }
}







