package com.example.libtest1;

public class MyClass {

    public static void main(String[] args) {
        Professor f = new Professor();
        f.setNum(2);
        f.setName("Mike");
        f.setDept("Computer");
        f.setAddress("Seoul");
        String[] sub = {"computer","C","Java"};
        f.setSubjects(sub);

        f.print();
        f.print_subject();

    }
}
