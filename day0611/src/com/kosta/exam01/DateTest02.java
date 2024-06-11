package com.kosta.exam01;

import java.util.Calendar;
import java.util.Date;

public class DateTest02 {
    public static void main(String[] args) {
        String[] arr = {"일", "월", "화", "수", "목", "금", "토"};

        // 이번달 1일의 요일을 확인하는 프로그램을 작성
        Date today = new Date();

        int year = today.getYear();
        int month = today.getMonth();

        // 이번 달 1일 날짜를 생성
        Date start = new Date(year, month, 1);
        int day = start.getDay();
        System.out.println(day);
        System.out.println(arr[day]);
    }
}
