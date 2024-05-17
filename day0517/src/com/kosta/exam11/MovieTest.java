package com.kosta.exam11;

class Movie {
    private String title;
    private String director;
    private String company;

    public String getTitle() {
        return title;
    }
    public String getCompany() {
        return company;
    }
    public String getDirector() {
        return director;
    }
}

public class MovieTest {

    public static void main(String[] args) {

        // 사용자가 생성자를 만들지 않아도, 자바가 기본 생성자를 만들어 줍니다.
        Movie m = new Movie();
        // 출력해보기(참조형은 null 반환)
        System.out.println(m.getTitle());
        System.out.println(m.getDirector());
        System.out.println(m.getCompany());

    }
}
