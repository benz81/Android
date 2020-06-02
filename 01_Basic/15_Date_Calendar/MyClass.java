package com.example.libtest1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyClass {

    public static void main(String[] args) {

        // "2020-05-14 11:12:43"
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd  Z");
        String strNow3 = sdf2.format(now);
        System.out.println(strNow3);


        Calendar now2 = Calendar.getInstance();
        int year = now2.get(Calendar.YEAR);
        int month = now2.get(Calendar.MONTH) + 1;
        int day = now2.get(Calendar.DAY_OF_MONTH);

        int week = now2.get(Calendar.DAY_OF_WEEK);
        String strWeek = null;
        switch (week){
            case Calendar.MONDAY:
                strWeek = "Mon";
                break;
            case Calendar.TUESDAY:
                strWeek = "Tue";
                break;
            case Calendar.WEDNESDAY:
                strWeek = "Wed";
                break;
            case Calendar.THURSDAY:
                strWeek = "THU";
                break;
            case Calendar.FRIDAY:
                strWeek = "FRI";
                break;
            case Calendar.SUNDAY:
                strWeek = "SUN";
                break;
        }
        System.out.println(strWeek);
        System.out.println(week);

        int amPm = now2.get(Calendar.AM_PM);
        String strAmPm = null;
        if(amPm == Calendar.AM){
            strAmPm = "AM";
        }else{
            strAmPm = "PM";
        }
        System.out.println(amPm);
        System.out.println(strAmPm);

        int hour = now2.get(Calendar.HOUR);
        int minute = now2.get(Calendar.MINUTE);
        int second = now2.get(Calendar.SECOND);

        System.out.println(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);


    }

}







