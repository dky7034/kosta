package com.kosta.exam01;

import java.util.Calendar;

// Calendar 클래스의 객체는 직접 생성할 수 없고
// static 메서드인 instance 메서드를 통해 생성할 수 있습니다.
public class CalendarTest {
    public static void main(String[] args) {
        String[] arr = {"일", "월", "화", "수", "목", "금", "토"};
        Calendar today = Calendar.getInstance();

        int year = today.get(Calendar.YEAR);
        System.out.println("year = " + year);

        int month = today.get(Calendar.MONTH);
        System.out.println("month = " + month + 1);

        int date = today.get(Calendar.DATE);
        System.out.println("date = " + date);

        int hour = today.get(Calendar.HOUR_OF_DAY);
        System.out.println("hour = " + hour);
        int minute = today.get(Calendar.MINUTE);
        System.out.println("minute = " + minute);
        int second = today.get(Calendar.SECOND);
        System.out.println("second = " + second);
        int day = today.get(Calendar.DAY_OF_WEEK);
        System.out.println("day = " + day);

        System.out.println("==============");

        System.out.println("오늘 요일: " + arr[day - 1] + "요일");
    }
}
