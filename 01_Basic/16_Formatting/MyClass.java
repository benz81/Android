package com.example.libtest1;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.sound.midi.SysexMessage;

public class MyClass {

    public static void main(String[] args) {
        // formatting
        double num = 1234567.89;

        DecimalFormat df = new DecimalFormat("0");
        System.out.println(df.format(num));

        df = new DecimalFormat("0.0");
        System.out.println(df.format(num));

        df = new DecimalFormat("0.00");
        System.out.println(df.format(num));

        df = new DecimalFormat("00000000000.00000");
        System.out.println(df.format(num));

        df = new DecimalFormat("#");
        System.out.println(df.format(num));

        df = new DecimalFormat("#.#");
        System.out.println(df.format(num));

        df = new DecimalFormat("#############.######");
        System.out.println(df.format(num));

        df = new DecimalFormat("#.0");
        System.out.println(df.format(num));

        df = new DecimalFormat("+#.0");
        System.out.println(df.format(num));

        df = new DecimalFormat("-#.0");
        System.out.println(df.format(num));

        df = new DecimalFormat("#,###.0");
        System.out.println(df.format(num));

        df = new DecimalFormat("0.0E0");
        System.out.println(df.format(num));

        df = new DecimalFormat("+#,### ; -#,###");
        System.out.println(df.format(num));

        df = new DecimalFormat("#.00 %");
        System.out.println(df.format(num));


        String id = "Java";
        String name = "Mike";
        String tel = "010-1234-5678";
        String gender = "male";

        String id2 = "Python";
        String name2 = "Harry";
        String tel2 = "010-5555-3333";
        String gender2 = "female";

        String text = "user Id : {0} \nuser name: {1} \ngender : {3} \nuser tel : {2}";

        String result1 = MessageFormat.format(text, id, name, tel, gender);
        System.out.println(result1);

        String result2 = MessageFormat.format(text, id2, name2, tel2, gender2);
        System.out.println(result2);


    }

}







