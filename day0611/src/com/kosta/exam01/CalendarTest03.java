package com.kosta.exam01;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Calendar 클래스의 객체는 직접 생성할 수 없고
// static 메서드인 instance 메서드를 통해 생성할 수 있습니다.
public class CalendarTest03 {
    public static void main(String[] args) {

        String[] arr = {"일", "월", "화", "수", "목", "금", "토"};

        // 이 달의 달력 출력하기
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int date = today.get(Calendar.DATE);
        int day = today.get(Calendar.DAY_OF_WEEK);
        System.out.println(year);
        System.out.println(date);
        System.out.println(day);
        System.out.println(month);

        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.println("===========================");
        for (int i = 1; i <= 30; i++) {
            System.out.print(i + "\t");
            if (i % 7 == 0) {
                System.out.println();
            }
        }

    }
}
