package com.example.libtest1;

public class MyClass {

    public static void main(String[] args) {

        Account account = new Account();
        account.setBalance(10000);
        System.out.println("Current balance : " + account.getBalance());

        account.setBalance(10000000);
        System.out.println("Current balance : "+account.getBalance());

        account.setBalance(-3000);
        System.out.println("Current balance : "+account.getBalance());
    }
}
