package com.kosta.exam;

public class D07ArrayCopyTest {
    
    public static void main(String[] args) {
        
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[5];
        for (int i=0; i<a.length; i++) {
            b[i] = a[i];
        }
        
        a[0] = 100;
        System.out.print("a 배열의 요소 ==> ");
        for (int data : a) {
            System.out.printf("%5d", data);
        }
        System.out.println();
        System.out.print("b 배열의 요소 ==> ");
        for (int data : b) {
            System.out.printf("%5d", data);
        }
        System.out.println();
        System.out.println(a == b);

    }
    
}
