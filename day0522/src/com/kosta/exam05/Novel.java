package com.kosta.exam05;

public class Novel extends Book {

    public Novel() {super();}
    public Novel(String number, String title, String author) {
        super(number, title, author);
    }

    // 부모메서드 오버라이딩
    @Override
    public int getLateFees(int days) {
        return days * 300;
    }
}
