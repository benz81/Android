package com.example.libtest1;

public class MyClass {

    public static void main(String[] args) {

        MemberService memberService = new MemberService();
        boolean result = memberService.login("hong", "12345");
        if(result){
            System.out.println("Log in.");
            memberService.logout("hong");
        }else{
            System.out.println("Not Correct.");
        }
    }
}







