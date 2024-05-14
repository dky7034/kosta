package com.kosta.exam;

public class D14MethodTestAdd {

    // 정수형 변수 2개를 매개변수로 전달받아 더하기한 결과를 출력하는 메서드 정의
    public static void printAdd(int a, int b) {
        int add = a + b;
        System.out.println("더하기 결과: " + add);

    }

    public static void main(String[] args) {
        printAdd(10, 20);
    }
    
}
