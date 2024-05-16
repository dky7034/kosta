package com.kosta.exam;

public class D04MethodCallByReferenceTest {
    
    // 정수형 배열을 매개변수로 전달받아 배열의 요소를 모두 1씩 증가하는 메서드
    public static void addOneAll(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            arr[i]++;
        }
        for (int j : arr) {
            System.out.printf("%5d", j);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2 ,3 ,4};
        addOneAll(array);
        System.out.println();
        for (int i : array) {
            System.out.printf("%5d", i);
        }
    }
}