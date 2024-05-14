package com.kosta.exam;

import java.util.Scanner;

public class D17MethodTestGugudan {

    // 몇 단을 출력할지를 매개변수로 전달받아 구구단을 출력하는 메서드
    public void gugudan(int num) {
        if (num < 1) {
            return;
        }
        System.out.printf("%d단을 출력합니다...\n", num);
        for (int i=1; i<=9; i++) {
            System.out.printf("%d X %d = %d\n", num, i, (num*i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        D17MethodTestGugudan obj = new D17MethodTestGugudan();
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 단을 출력할까요? ==> ");
        int n = sc.nextInt();
        obj.gugudan(n);
        
    }
    
}
