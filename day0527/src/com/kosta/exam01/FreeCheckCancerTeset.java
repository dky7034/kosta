package com.kosta.exam01;

import java.util.Date;
import java.util.Scanner;

// 사용자한테 주민번호를 입력받아(하이픈 포함) 무료 암검진 대상자인지
// 판별하는 프로그램을 작성해 봅시다.
// 무료 암검진 대상자는 공통으로 40세 이상이고,
// 올해가 홀수연도이면 홀수연도에 태어난 사람이 대상이고
// 올해가 짝수연도이면 짝수연도에 태어난 사람이 대상입니다.
// 무료 암검진 항목은 다음과 같습니다:
// 40세 이상 남자 위암, 간암, 일반암
// 40세 이상 여자 위암, 간암, 일반암, 자궁암, 유방암
// 50세 이상 남자 위암, 간암, 일반암, 대장암
// 50세 이상 여자 위암, 간암, 일반암, 대장암, 자궁암, 유방암
public class FreeCheckCancerTeset {
    public static void main(String[] args) {
        // 사용자한테 주민번호를 입력받습니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("주민번호를 입력해 주세요(하이픈 포함) ==> ");
        String jumin = sc.next();

        // 올해 연도를 구합니다.
        int thisYear = (new Date().getYear() + 1900);
        System.out.println(thisYear);

        // 사용자의 나이를 구합니다.
        // 주민번호 뒷자리가 1, 2로 시작하면 1900년대 생.
        // 주민번호 뒷자리가 3, 4로 시작하면 2000년대 생입니다.
        // 나이 = 현재연도 - 출생년도 + 1
        // 주민번호 뒷자리 중 첫째자리를 구합니다.
        int num = Integer.parseInt(String.valueOf(jumin.charAt(7)));
        System.out.println("num = " + num);
        int age, birthYear;
        birthYear = Integer.parseInt(jumin.substring(0, 2));
        if (num == 1 || num == 2) {
            birthYear += 1900;
        } else if (num == 3 || num == 4) {
            birthYear += 2000;
        } else {
            System.out.println("잘못된 주민번호입니다.");
            return;
        }
        age = thisYear - birthYear + 1;
        System.out.println("사용자의 나이는 " + age + "살입니다.");

        // 암검진 대상자인지 판별합니다.
        if (age < 40) {
            System.out.println("암검진 대상자가 아닙니다.");
            return;
        }
        // 홀수연도, 짝수연도에 따른 검진 대상을 판별합니다.
        // num(주민번호 뒷자리 중 첫째자리)이 1 또는 3이면 남자, 2 또는 4이면 여자입니다.
        if (thisYear % 2 == birthYear % 2) {
            System.out.println("암검진 대상자가 아닙니다.");
            if (age >= 50) { // 50세 이상
                if (num % 2 == 0) { // 여자
                    System.out.println("위암, 간암, 일반암, 대장암, 자궁암, 유방암 검진 대상자입니다.");
                } else { // 남자
                    System.out.println("위암, 간암, 일반암, 대장암 검진 대상자입니다.");
                }
            } else {
                if (num % 2 == 0) { // 여자
                    System.out.println("위암, 간암, 일반암, 자궁암, 유방암 검진 대상자입니다.");
                } else { // 남자
                    System.out.println("위암, 간암, 일반암 검진 대상자입니다.");
                }
            }
        }

    }
}
