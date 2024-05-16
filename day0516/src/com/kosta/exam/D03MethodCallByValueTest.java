package com.kosta.exam;

public class D03MethodCallByValueTest {

    // 정수형 변수 하나를 매개변수로 전달받아 1증가하여 출력하는 메서드
    public static void add(int n) {
        n += 1;
        System.out.println("n: " + n);
    }

    public static void main(String[] args) {
        int a;
        a = 5;
        add(a);
        System.out.println("a: " + a);
        System.out.print("add(a): ");

    }
    
}