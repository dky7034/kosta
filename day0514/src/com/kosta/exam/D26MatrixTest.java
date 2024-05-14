package com.kosta.exam;

public class D26MatrixTest {

    // 정수형의 2차원 배열을 매개변수로 전달받아 모든 요소를 출력하는 메서드를 정의하고,
    // 호출해 봅니다. 
    public static void printAllElem(int[][] arr) {
        for (int[] array : arr) {
            for (int elem : array) {
                System.out.printf("%5d", elem);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};

        int[][] b = {   
                        {10, 20, 30},
                        {40, 50, 60},
                        {70, 80, 90},
                        {100, 110, 120}   
                    };

        int[][] c = {   
                        {1, 2, 3, 4, 5},
                        {6, 7},
                        {8, 9, 10}    
                    };
        
        System.out.println("b 출력:");
        printAllElem(b);
        
        System.out.println("=============================");

        System.out.println("c 출력:");
        printAllElem(c);
        
    }

}
