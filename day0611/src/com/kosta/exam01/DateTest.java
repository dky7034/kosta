package com.kosta.exam01;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date today = new Date();
        int year = today.getYear() + 1900;
        int month = today.getMonth() + 1;
        int date = today.getDate();
        int hours = today.getHours();
        int minutes = today.getMinutes();
        int seconds = today.getSeconds();

        int day = today.getDay();

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("date = " + date);
        System.out.println("hours = " + hours);
        System.out.println("minutes = " + minutes);
        System.out.println("seconds = " + seconds);
        System.out.println("day = " + day);
    }
}
