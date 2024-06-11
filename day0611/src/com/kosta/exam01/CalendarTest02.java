package com.kosta.exam01;

import java.util.Calendar;

// Calendar 클래스의 객체는 직접 생성할 수 없고
// static 메서드인 instance 메서드를 통해 생성할 수 있습니다.
public class CalendarTest02 {
    public static void main(String[] args) {

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
