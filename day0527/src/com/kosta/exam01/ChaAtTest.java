package com.kosta.exam01;

public class ChaAtTest {
    public static void main(String[] args) {
        String data = "hello java";
        String name = "홍석영";
        String year = "2024";
        char c1 = data.charAt(0);
        char c2 = name.charAt(1);
        // 데이터를
        int c3 = Integer.parseInt(year.charAt(0) + "");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
