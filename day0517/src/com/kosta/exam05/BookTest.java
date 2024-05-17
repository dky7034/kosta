package com.kosta.exam05;

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

    Book(String t, String a) {
        System.out.println("생성자 동작2...");
        this.title = t;
        this.author = a;
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