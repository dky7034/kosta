package com.kosta.exam;

public class D15MethodTestSumArray {

    // 정수형 배열 2개를 매개변수로 전달받아 총합을 누적하여 출력하는 메서드
    // 메서드에서 static이 없으면 메서드를 호출하기 위한 인스턴스를 생성해야 함
    // 예시)
    // 인스턴스를 생성:
    // D15MethodTestSumArray obj = new D15MethodTestSumArray();
    // obj.printSumArry(a, b);
    public static void printSumArray(int[] arr1, int[] arr2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i : arr1) {
            sum1 += i;
        }
        for (int i : arr2) {
            sum2 += i;
        }
        int tot = sum1 + sum2;
        System.out.println("총합 => " + tot);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7, 8, 9, 10};
        printSumArray(a, b);
    }
    
}
