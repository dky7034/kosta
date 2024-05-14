package com.kosta.exam;

public class D09ArrayCopyTestMethod {
    
    // 정수형 배열을 매개변수로 전달받아서 배열의 요소를 모두 출력하는 메서드(함수 만들기...)
    public static void printArray(String str, int[] array) {
        System.out.print(str);
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
        
        printArray("a배열의 요소 ==> ", a);
        printArray("b배열의 요소 ==>", b);
        a[0] = 100;
        printArray("a배열의 요소 ==> ", a);
        printArray("b배열의 요소 ==>", b);

    }
    
}
