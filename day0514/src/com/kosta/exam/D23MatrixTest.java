package com.kosta.exam;

public class D23MatrixTest {

    public static void main(String[] args) {
        
        // 2차원 배열: 정수형 변수 12개...
        int[][] a = new int[3][4];

        int n = 1;
        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                a[i][j] = n;
                n++;
            }
        }

        // for-each문을 활용한 출력
        for (int[] row : a) { // 각 행을 반복
            for (int elem : row) { // 각 행의 요소를 반복
                System.out.println("element: " +  elem);
            }
        }

    }
    
}
