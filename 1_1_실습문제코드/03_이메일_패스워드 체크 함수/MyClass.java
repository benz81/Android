package com.example.libtest1;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    static boolean checkEmail(String email) { // email = "mike@naver.com"
        if (email.indexOf("@") == -1) {
            return false;
        } else {
            return true;
        }
    }

    static boolean checkEmail2(String email) {
        if (email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    static boolean checkPasswd(String passwd1, String passwd2) {
        if (passwd1.compareTo(passwd2) == 0) {
            if (passwd1.length() < 6 || passwd1.length() > 12) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String email = "mikenaver.com";
        System.out.println(checkEmail(email));

        System.out.println("-----------------------------");

        String passwd1 = "123456";
        String passwd2 = "123456";
        System.out.println(checkPasswd(passwd1, passwd2));

    }
}







