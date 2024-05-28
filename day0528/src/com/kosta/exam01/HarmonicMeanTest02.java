package com.kosta.exam01;

import java.util.Scanner;

// 조화평균이 있을 수 없는 사용자 정의 예외를 만들어 줍시다.
class NotHarmonicMeanException extends Exception {
    public NotHarmonicMeanException(String msg) {
        super(msg);
    }
}

// 사용자한테 두 수를 입력받아 "조화평균"을 구하여 출력하는 프로그램을 작성
public class HarmonicMeanTest02 {
    public static void main(String[] args) {
// 이것도 가능함
//        Scanner sc = new Scanner(System.in);
//        int a, b, mean;
//        System.out.print("첫번째 수 입력 ==> ");
//        a = sc.nextInt();
//        System.out.print("두번째 수 입력 ==> ");
//        b = sc.nextInt();
//
//        // HarmonicMean이 발생할 수 없는 예외 조건을 선언
//        if (a == -b) {
//            try {
//                throw new NotHarmonicMeanException(a + "와 " + b + " 두 수의 조화평균은 발생할 수 없습니다!");
//            } catch (NotHarmonicMeanException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        mean = (2 * a * b) / (a + b);
//        System.out.println("두 수의 조화평균은 " + mean);
//    }

        try {
            Scanner sc = new Scanner(System.in);
            int a, b, mean;
            System.out.print("첫번째 수 입력 ==> ");
            a = sc.nextInt();
            System.out.print("두번째 수 입력 ==> ");
            b = sc.nextInt();

            // HarmonicMean이 발생할 수 없는 예외 조건을 선언
            if (a == -b) {
                throw new NotHarmonicMeanException(a + "와 " + b + " 두 수의 조화평균은 발생할 수 없습니다!");
            }

            mean = (2 * a * b) / (a + b);
            System.out.println("두 수의 조화평균은 " + mean);
        } catch (NotHarmonicMeanException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
