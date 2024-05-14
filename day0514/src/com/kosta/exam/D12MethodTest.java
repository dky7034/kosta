package com.kosta.exam;

import java.util.Scanner;

public class D12MethodTest {

    // 메서드 생성
    public static void sayHello(String str, int n) {  
        for (int i=0; i<n; i++) {
            System.out.printf("%s야 안녕\n", str);
        } 
    }

    public static void main(String[] args) {
        
        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        System.out.print("누구한테 인사할까? ==> ");
        String str = sc.next();
        sayHello(str, 2);
        String title = "KOSTA 교육센터";
        System.out.println(title);
        sayHello(str, 3);
        int year = 2024;
        System.out.println(year);
        sayHello(str, 1);

    }

}
