package com.kosta.exam05;

public class BookTest {

    public static void main(String[] args) {
        // 추상
        Book b1 = new Novel("1", "novel", "홍길동");
        Book b2 = new Poet("1", "poet", "강동균");
        Book b3 = new ScienceFiction("1", "Science Fiction", "박준규");

        int novelLateFee = b1.getLateFees(3);
        int poetLateFee = b2.getLateFees(5);
        int scienceFictionFee = b3.getLateFees(2);

        System.out.println("novel 연체료 => " + novelLateFee);
        System.out.println("poet 연체료 => " + poetLateFee);
        System.out.println("scienceFiction 연체료 => " + scienceFictionFee);

    }

}
