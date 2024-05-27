package com.kosta.exam01;

public class TrimTest {
    public static void main(String[] args) {
        String data = "   hello   ";
        System.out.println(data.length()); // 공백도 카운트.
        System.out.println(data);
        System.out.println("|" + data + "|");

        // trim() 메서드
        System.out.println(data.trim());
        System.out.println("|" + data.trim() + "|");
        System.out.println(data);
    }
}
