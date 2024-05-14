package com.kosta.exam;

import java.util.Scanner;

public class D20MethodGetFactorial {

    public static int getFactorial(int n) {
        int result = 1;
        for (int i=1; i<=n; i++) {
            result = result * n;
            n--;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("계산할 정수 n을 입력해 주세요 => ");
        int n = sc.nextInt();
        System.out.printf("%d! 결과: %d", n, getFactorial(n));
    }
    
}