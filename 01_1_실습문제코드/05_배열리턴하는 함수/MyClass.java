package com.example.libtest1;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    static int[] get_array(int number){
        int[] ret = new int[number];
        for( int i = 0; i < number; i++){
            ret[i] = i+1;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] my_arr = get_array(7);

        for(int i = 0; i < my_arr.length; i++){
            System.out.println(my_arr[i]);
        }
    }
}







