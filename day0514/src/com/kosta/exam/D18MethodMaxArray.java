package com.kosta.exam;

public class D18MethodMaxArray {

    // 정수형 배열을 매개변수로 전달받아 가장 큰값을 찾아서 출력하는 메서드를 정의합니다.
    public static void printMaxArray(int[] arr) {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("최댓값 = " + max);
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 1, 9, 11, 3, 4};
        printMaxArray(array);
    }
    
}
