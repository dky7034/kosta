package com.kosta.exam01;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Calendar 클래스의 객체는 직접 생성할 수 없고
// static 메서드인 instance 메서드를 통해 생성할 수 있습니다.
public class CalendarTest04 {
    public static void main(String[] args) {
        GregorianCalendar today = new GregorianCalendar(); // 현재 날짜와 시간을 나타내는 GregorianCalendar 객체 생성
        String[] arr = {"일", "월", "화", "수", "목", "금", "토"}; // 요일 배열 생성

        // 이 달의 달력 출력하기
        int year = today.get(Calendar.YEAR); // 현재 연도 가져오기
        int month = today.get(Calendar.MONTH); // 현재 월 가져오기 (0~11, 0이 1월)

        GregorianCalendar start = new GregorianCalendar(year, month, 1); // 이번 달 1일을 나타내는 객체 생성
        int day = start.get(Calendar.DAY_OF_WEEK); // 이번 달 1일의 요일 가져오기 (1: 일요일, 2: 월요일, ..., 7: 토요일)
        System.out.println("day = " + day);

        System.out.println("년: " + year); // 현재 연도 출력
        System.out.println("월: " + (month + 1)); // 현재 월 출력 (0부터 시작하므로 1 더함)
        System.out.println("1일의 요일: " + arr[day - 1]); // 1일의 요일 출력 (배열 인덱스 맞추기 위해 1 빼줌)

        System.out.println("일\t월\t화\t수\t목\t금\t토"); // 요일 헤더 출력
        System.out.println("===========================");

        // 1일이 시작되는 위치에 맞게 탭으로 공백 추가
        for (int j = 1; j < day; j++) {
            System.out.print("\t");
        }

        // 이번 달의 모든 날짜를 출력
        int maxDay = start.getActualMaximum(Calendar.DAY_OF_MONTH); // 이번 달의 마지막 날 가져오기
        for (int i = 1; i <= maxDay; i++) {
            System.out.print(i + "\t"); // 날짜 출력 후 탭 추가
            if ((i + day - 1) % 7 == 0) { // 날짜 출력 후 줄바꿈 (일주일 단위로)
                System.out.println();
            }
        }

        System.out.println(); // 마지막 줄바꿈
    }
}
