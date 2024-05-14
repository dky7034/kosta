package com.kosta.exam;

public class D19MethodAddReturn {
    
    // 두 개의 정수를 매개변수로 전달받아 더하기한 결과를 반환하는 메서드 정의
    public static int getAdd(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = getAdd(2, 8);
        System.out.println("result = " + result);
        System.out.println(getAdd(20,30));
    }

}
