package com.kosta.exam07;

class Book {
    private String title;
    private String author;

    public Book() {
        title = "제목없음";
        author = "저자없음";
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public Book(String title) {
        this.title = title;
        this.author = "저자없음";
    }
    // 생성자의 매개변수 이름을 의미있는 이름으로 정해주다보면, 멤버와 이름이 겹치게 되고
    // 생성자 body 에서는 매개변수가 우선순위가 높아서 멤버변수는 초기화가 되지 않습니다.
    // 생성자나 메서드를 생성하는 경우, 멤버변수명과 매개변수명이 겹치는 경우가 발생합니다.
    // 이때, 멤버변수 자신을 구별하기 위해 this를 사용합니다.
//    Book(String title, String author) {
//        title = title;
//        author = author;
//    }
}

public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("재미있는 자바", "임유나");
        // private 영역의 멤버변수에 직접 접근할 수 없습니다.
        // public에 있는 메서드를 통하여 접근하도록 해야 합니다.
        // 접근해서 값을 변경시키는 기능: setXXX() ==> setter 설정자
        // 접근해서 값을 읽어오는 기능:   getXXX() ==> getter 접근자
    }
}