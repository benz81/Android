package com.example.libtest1;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        // x,y는 0~10 자연수
        // 4x + 5y = 60  를 만족하는 수 찾기
        for( int x = 0 ; x <= 10  ; x++  ){
            for( int y = 0 ; y <= 10 ; y++ ) {
                if(  (4*x + 5*y) == 60  ){
                    System.out.println("("+x+", "+y+")");
                }
            }
        }
    }
}







