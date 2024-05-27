package com.kosta.exam01;

public class LastIndexOfTest {
    public static void main(String[] args) {
        String data = "java";
        int n1 = data.indexOf("a"); // 앞에서부터 a의 인덱스를 찾음.
        int n2 = data.lastIndexOf("a"); // 뒤에서부터 a의 인덱스를 찾음.

        System.out.println(n1);
        System.out.println(n2);
    }
}
