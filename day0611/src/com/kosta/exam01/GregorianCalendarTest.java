package com.kosta.exam01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {
    public static void main(String[] args) {
        String[] arr = {"일", "월", "화", "수", "목", "금", "토"};
        GregorianCalendar today = new GregorianCalendar();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH) + 1;
        int date = today.get(Calendar.DAY_OF_MONTH);
        int day = today.get(Calendar.DAY_OF_WEEK);
        int hour = today.get(Calendar.HOUR_OF_DAY);
        int minute = today.get(Calendar.MINUTE);
        int second = today.get(Calendar.SECOND);

        System.out.println(year + "년 " + month + "월 " + date + "일 " + arr[day - 1] + "요일 " + hour + ":" + minute + ":" + second);

        if (today.isLeapYear(year)) {
            System.out.println("윤년입니다.");
        } else {
            System.out.println("윤년이 아닙니다.");
        }
    }
}
