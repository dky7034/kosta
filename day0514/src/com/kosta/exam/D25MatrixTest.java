package com.kosta.exam;
/*
 *      0 [][][][][]
 *      1 [][]
 *      2 [][][][][][][][][][]
 */

// 배열의 요소에 
public class D25MatrixTest {
    
    public static void main(String[] args) {
        int[][] a = new int[10][];
        
        a[0] = new int[1];
        a[1] = new int[2];
        a[2] = new int[3];
        a[3] = new int[4];
        a[4] = new int[5];
        a[5] = new int[6];
        a[6] = new int[7];
        a[7] = new int[8];
        a[8] = new int[9];
        a[9] = new int[10];

        for (int i=0; i<a.length; i++) { // 각 행의 길이만큼 반복(배열을 가지는 배열의 길이...)
            for (int j=0; j<a[i].length;j++) { // 각 행에 해당하는 열의 길이만큼 반복(배열 안에 있는 배열의 길이...)
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
