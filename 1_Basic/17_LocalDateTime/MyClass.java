package com.example.libtest1;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.sound.midi.SysexMessage;

public class MyClass {

    public static void main(String[] args) {
        // time
        LocalDate currDate = LocalDate.now();
        System.out.println("current Date : " + currDate);

        LocalDate targetDate = LocalDate.of(2024, 5, 10);
        System.out.println("target Date : " + targetDate);
        System.out.println();

        LocalTime currTime = LocalTime.now();
        System.out.println("current Time : " + currTime);

        LocalTime targetTime = LocalTime.of(23, 30, 0, 0);
        System.out.println("target Time : " + targetTime);

        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("current : " + currDateTime);

        LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 23, 30, 0, 0);
        System.out.println("target : " + targetDateTime);

        ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("UTC : " + utcDateTime);

        ZonedDateTime newyorkDateTime =
                ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("new york : " + newyorkDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        String strDateTime = now.getYear() + "/";
        strDateTime += now.getMonth() + "/";
        strDateTime += now.getDayOfMonth() + " ";
        System.out.println(strDateTime);

        LocalDate nowDate = now.toLocalDate();
        if(nowDate.isLeapYear()){
            System.out.println("Yes Leap Year, 29");
        }else{
            System.out.println("No Leap Year, 28");
        }

        LocalDateTime newDate = now.plusYears(1)
                .minusMonths(2).plusDays(4).plusHours(2);
        System.out.println(newDate);


    }

}







