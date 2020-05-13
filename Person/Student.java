package com.example.libtest1;

public class Student extends Person {
    private String[] subjects;
    void print_subject(){
        System.out.println(name + "'s subject");
        for(int i = 0; i < subjects.length; i++){
            System.out.println("subject : "+subjects[i]);
        }
    }
    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
    public String[] getSubjects() {
        return subjects;
    }
}
