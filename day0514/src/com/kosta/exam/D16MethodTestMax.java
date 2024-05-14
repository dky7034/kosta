package com.kosta.exam;

import java.util.Scanner;

public class D16MethodTestMax {

    // 두 개의 실수를 매개변수로 전달받아, 그중에 큰 수를 찾아 출력하는
    // 메서드를 정의하고 호출해 봅시다.

    public static void findBigNum(double a, double b) {
        double max = a;
        if (max < b) {
            max = b;
        }
        System.out.printf("두 개의 실수중에 큰 수는 %.3f입니다.", max);

    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("실수를 입력해 주세요 => ");
        double a = sc.nextDouble();
        System.out.print("실수를 한 번 더 입력해 주세요 => ");
        double b = sc.nextDouble();
        findBigNum(a, b);
    }
    
}
