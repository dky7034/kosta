package com.kosta.exam01;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class AgeFromJumin {
    public static void main(String[] args) {
        // 현재 연도 구하기
        Date date = new Date();
        int thisYear = date.getYear() + 1900;
        System.out.println(thisYear);

        // 사용자한테 주민번호 모두 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("주민번호를 모두 입력해 주세요(하이픈 제외) ==> ");
        String jumin = sc.next();
        if (jumin.length() < 13) {
            System.out.println("주민번호를 다시 입력해 주세요.");
            return;
        }

        // 사용자의 나이 계산
        // 주민번호 뒷자리 시작이 1이거나 2이면 1900년대생,
        // 주민번호 뒷자리 시작이 3이거나 4이면 2000년대생
        int birthYear, num, age;
        birthYear = Integer.parseInt(jumin.substring(0, 2));
        num = Integer.parseInt(jumin.substring(6, 7));
        if ((num == 1 || num == 2)) {
            birthYear += 1900;
        } else if (num == 3 || num == 4) {
            birthYear += 2000;
        } else {
            System.out.println("잘못된 주민번호입니다...");
        }
        age = thisYear - birthYear + 1;
        System.out.println("사용자의 나이는 " + age + "살입니다.");

    }
}
