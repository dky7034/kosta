package com.kosta.exam06;

public class MagazinTest {
    public static void main(String[] args) {

        Magazine m1 = new Magazine();
        Magazine m2 = new Magazine("제목", 400, "홍길동", "2024년 5월 20일");
        System.out.println("*** 출력 ***");
        System.out.println("제목: " + m2.title);
        System.out.println("페이지 수: " + m2.page);
        System.out.println("저자: " + m2.author);
        System.out.println("출판일: " + m2.getReleaseDate());
        System.out.println(m2);

    }
}
