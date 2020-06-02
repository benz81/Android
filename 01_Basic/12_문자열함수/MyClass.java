package com.example.libtest1;

public class MyClass {

    public static void main(String[] args) {
        System.out.println("concat() test : " + "abc".concat("def"));

        String strVar = new String("hello");
        String strVar2 = "hellO";

        String concatStr = strVar.concat(strVar2);
        System.out.println(concatStr);

        if(strVar == strVar2){
            System.out.println("the same String");
        }else{
            System.out.println("different");
        }

        if(strVar.compareTo(strVar2) == 0){
            System.out.println("the same String");
        }else{
            System.out.println("different");
        }

        if(strVar.equals(strVar)){
            System.out.println("the same String");
        }else{
            System.out.println("different");
        }

        String subject = "java programming language class";
        int location = subject.indexOf("ja");
        System.out.println(location);

        if(subject.indexOf("mango") != -1){
            System.out.println("exists");
        }else{
            System.out.println("No word");
        }
//        String subject = "java programming language class";
        System.out.println(subject.substring(0, 4));
        System.out.println(subject.substring(5, 16));

        String ssn = "472348472049327834";
        int len1 = ssn.length();
        int len2 = subject.length();
        System.out.println(len1);
        System.out.println(len2);

        if("programming".compareTo(" programming") == 0){
            System.out.println("Same");
        }else{
            System.out.println("Different");
        }

        String ex1 = " pro gramming";
        String ex2 = "pro gramming   ";
        String ex3 = "    pro gramming       ";
        System.out.println("ex1 : " + ex1.length() + ", ex2 : "
        + ex2.length() + ", ex3 : "+ex3.length());

        ex1 = ex1.trim();
        ex2 = ex2.trim();
        ex3 = ex3.trim();
        System.out.println("ex1 : " + ex1.length() + ", ex2 : "
                + ex2.length() + ", ex3 : "+ex3.length());
        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);


        //String subject = "java programming language class";
        String search_word = "JaVa";

        subject = subject.toLowerCase();
        search_word = search_word.toLowerCase();

        if(subject.indexOf(search_word) != -1){
            System.out.println("exists");
        }else{
            System.out.println("No word");
        }
        search_word = search_word.toUpperCase();
        System.out.println(search_word);

        String color = "red, blue, white, orange";
        String[] arr = color.split(", ");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        //String subject = "java programming language class";
        String[] arr2 = subject.split(" ");
        for(int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }

        String[] arr3 = subject.split("ing");
        for(int i = 0; i < arr3.length; i++){
            System.out.println(arr3[i]);
        }

        //String subject = "java programming language class";
        String rep_str = subject.replace("java", "Python");
        System.out.println(subject);
        System.out.println(rep_str);

        //String subject = "java programming language class";
        System.out.println(subject.contains("class"));
        if(subject.contains("class")){
            System.out.println("subject");
        }else {
            System.out.println("not subject");
        }

        String url = "https://www.naver.com";
        System.out.println(url.startsWith("http"));
        if(url.startsWith("http")){
            System.out.println("Web");
        }else{
            System.out.println("Not Web");
        }
        System.out.println(url.endsWith("kr"));
        if(url.endsWith("kr")){
            System.out.println("Korea");
        }else{
            System.out.println("Not Korea");
        }


    }
}







