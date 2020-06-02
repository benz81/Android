package com.example.libtest1;

public class MyClass {

    static int cal(int value1, int value2, String operator){
        int ret = 0;
        if(operator.compareTo("add") == 0 ){
            ret = value1+value2;
        }else if(operator.compareTo("mul") == 0){
            ret = value1 * value2;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(cal(3, 4, "add"));
        System.out.println(cal(4,8, "mul"));
        System.out.println(cal(6, 12, "asdfd"));
    }
}







