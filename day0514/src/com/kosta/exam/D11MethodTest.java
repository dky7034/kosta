package com.kosta.exam;

import java.util.Scanner;

public class D11MethodTest {

    // 메서드 생성
    public static void sayHello(String str) {   
        System.out.printf("%s야 안녕", str);
        System.out.printf("%s야 안녕", str);
        System.out.printf("%s야 안녕", str);
    }

    public static void main(String[] args) {
        
        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);
        System.out.print("누구한테 인사할까? ==> ");
        String str = sc.next();
        sayHello(str);
        System.out.println();
        String title = "KOSTA 교육센터";
        sayHello(str);
        System.out.println(title);
        int year = 2024;
        System.out.println(year);
        sayHello(str);

    }

}
