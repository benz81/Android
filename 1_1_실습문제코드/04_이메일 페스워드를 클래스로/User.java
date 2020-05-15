package com.example.libtest1;

public class User {

    private String email;
    private String passwd;
    public String nickname;

    User(String nickname){
        this.nickname = nickname;
    }
    boolean setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
            System.out.println("email ok : " + this.email);
            return true;
        } else {
            return false;
        }
    }
    boolean setPasswd(String passwd1, String passwd2) {
        if (passwd1.compareTo(passwd2) == 0) {
            if (passwd1.length() < 6 || passwd1.length() > 12) {
                return false;
            } else {
                this.passwd = passwd1;
                System.out.println("passwd ok : " + passwd);
                return true;
            }
        } else {
            return false;
        }
    }

    void print(){
        System.out.println("email : " + email);
        System.out.println("passwd : " + passwd);
        System.out.println("nickname : " + nickname);
    }

}
