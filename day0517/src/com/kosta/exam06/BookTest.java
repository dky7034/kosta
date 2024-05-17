package com.kosta.exam06;

class Book {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    // 생성자
    public Book(String title) {
        this.title = title;
    }

    Book() {
        System.out.println("생성자 동작...");
        title = "재미있는 자바";
        author = "홍길동";
    }

    // 생성자의 매개변수 이름을 의미있는 이름으로 정해주다보면, 멤버와 이름이 겹치게 되고
    // 생성자 body 에서는 매개변수가 우선순위가 높아서 멤버변수는 초기화가 되지 않습니다.
    // 생성자나 메서드를 생성하는 경우, 멤버변수명과 매개변수명이 겹치는 경우가 발생합니다.
    // 이때, 멤버변수 자신을 구별하기 위해 this를 사용합니다.
//    Book(String title, String author) {
//        title = title;
//        author = author;
//    }
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("재미있는 자바", "임유나");
        // private 영역의 멤버변수에 직접 접근할 수 없습니다.
        // public에 있는 메서드를 통하여 접근하도록 해야 합니다.
        // 접근해서 값을 변경시키는 기능: setXXX() ==> setter 설정자
        // 접근해서 값을 읽어오는 기능:   getXXX() ==> getter 접근자

        System.out.println("b1.getTitle() = " + b1.getTitle());
        System.out.println("b1.getAuthor() = " + b1.getAuthor());

        System.out.println();

        System.out.println("b2.getTitle() = " + b2.getTitle());
        System.out.println("b2.getAuthor() = " + b2.getAuthor());

    }
}