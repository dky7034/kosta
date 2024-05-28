package com.kosta.exam04;

import java.util.Scanner;
import java.util.StringTokenizer;

// 예외 클래스
class IllegalArgumentException extends Exception {
    public IllegalArgumentException(String message) {
        super(message);
    }
}

class MyDate {
    // 메서드
    public void extractYearMonthDay(String data) throws IllegalArgumentException {
        if (data.equals(null) || data.isEmpty()) {
            throw new IllegalArgumentException("data가 null이 될 수는 없습니다.");
        }
        StringTokenizer st = new StringTokenizer(data, "/");
        if (st.countTokens() != 3) {
            throw new IllegalArgumentException("data의 형식이 잘못되었습니다. YEAR/MONTH/DATE 형태여야 합니다.");
        }
        String year = st.nextToken();
        String month = st.nextToken();
        String date = st.nextToken();
        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("date = " + date);
    }

    // 생성자
    public MyDate(String data) {
        try {
            extractYearMonthDay(data);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}

public class MyDataTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** 연, 월, 일을 추출하는 프로그램 ***");
        System.out.print("YEAR/MONTH/DATE 형태로 입력해 주세요 ==> ");
        String input = sc.nextLine();

        // MyDate 객체 생성
        MyDate myDate = new MyDate(input);

        sc.close();
    }
}
