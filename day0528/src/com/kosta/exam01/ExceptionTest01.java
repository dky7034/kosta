package com.kosta.exam01;

public class ExceptionTest01 {
    public static void calcDiv(int a, int b) {
        int result = a / b;
        System.out.println("나누기 결과: " + result);
    }

    public static void main(String[] args) {
        calcDiv(4, 2);
        calcDiv(4, 0);
    }

}
