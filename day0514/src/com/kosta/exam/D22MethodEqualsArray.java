package com.kosta.exam;

import java.util.Arrays;
import java.util.Scanner;

public class D22MethodEqualsArray {
    
    // 실수형 배열 2개를 매개변수로 전달받아 두 배열이 서로 동일한지 판별하여
    // boolean을 반환하도록 메서드를 정의합니다.
    public static boolean isEquals(double[] a, double[] b) {
        boolean flag = true;
        if (a.length != b.length) {
            return false;
        }
        for(int i=0; i<a.length; i++) {
            if (a[i] != b[i]) {
                System.out.println("두 배열은 다릅니다...");
                return false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        
        double[] a = {1.1, 2.3, 4.5};
        double[] b = {4.5, 2,3, 1,1};

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(isEquals(a, b));
        
    }

}
