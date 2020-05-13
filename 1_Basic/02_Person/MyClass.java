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

        Student s = new Student();
        s.setNum(3);
        s.setName("Paul");
        s.setDept("Computer");
        s.setAddress("BuCheon");
        String[] studentClass = {"Java", "Compiler"};
        s.setSubjects(studentClass);

        s.print();
        s.print_subject();

        Staff sf = new Staff();
        sf.setNum(4);
        sf.setName("Harry");
        sf.setDept("Edu");
        sf.setAddress("KyungGi");
        sf.setJob("Edu manager");

        sf.print();
        sf.print_job();

    }
}
