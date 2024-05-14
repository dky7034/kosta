package com.kosta.exam;

public class D08ArrayCopyTestMethod {
    
    // 정수형 배열을 매개변수로 전달받아서 배열의 요소를 모두 출력하는 메서드(함수 만들기...)
    public static void printArray(int[] array) {
        for (int data : array) {
            System.out.printf("%5d", data);
        }
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[5];
        for (int i=0; i<a.length; i++) {
            b[i] = a[i];
        }
        
        a[0] = 100;
        System.out.print("a 배열의 요소 ==> ");
        printArray(a);
        System.out.println();
        System.out.print("b 배열의 요소 ==> ");
        printArray(b);
        System.out.println();

    }
    
}
