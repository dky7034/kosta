package com.kosta.exam02;

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
}

public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book();
        // private 영역의 멤버변수에 직접 접근할 수 없습니다.
        // public에 있는 메서드를 통하여 접근하도록 해야 합니다.
        // 접근해서 값을 변경시키는 기능: setXXX() ==> setter 설정자
        // 접근해서 값을 읽어오는 기능:   getXXX() ==> getter 접근자
        b1.setTitle("신나는 자바");
        b1.setAuthor("...");
        b2.setTitle("신나는 코딩");
        b2.setAuthor("...");

        System.out.println("b1.getTitle() = " + b1.getTitle());
        System.out.println("b1.getAuthor() = " + b1.getAuthor());
        System.out.println("b2.getTitle() = " + b2.getTitle());
        System.out.println("b2.getAuthor() = " + b2.getAuthor());

    }
}