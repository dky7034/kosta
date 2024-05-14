package com.kosta.exam;

public class D06 {

    public static void main(String[] args) {
        
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[5];
        b = a;
        
        for (int x : b) {
            System.out.printf("%5d", x);
        }
        
        System.out.println();

        for (int x : a) {
            
            System.out.printf("%5d", x);
        }
        
        System.out.println();

        // a를 b에 복사
        for (int i=0; i<a.length; i++) {
            b[i] = a[i];
        }
        
        for (int x : b) {
            System.out.printf("%5d", x);
        }

    }
    
}
