package com.kosta.exam01;

/*
사용자한테 주민등록번호를 입력받아 올바른 주민등록번호인지 판별하는 프로그램
<< 처리조건 >>
‘ㅍ’은 주민등록번호에 오류가 없는지 확인하는 검증번호로, 아래와 같은 특수한 규칙으로 만든다.
ㅍ = 11-{(2×ㄱ+3×ㄴ+4×ㄷ+5×ㄹ+6×ㅁ+7×ㅂ+8×ㅅ+9×ㅇ+2×ㅈ+3×ㅊ+4×ㅋ+5×ㅌ) mod 11}
즉, 소괄호 안에 있는 것을 계산한 값을 11로 나눠서 나온 나머지를 11에서 뺀 값이 ㅍ이다. (단, 10은 0, 11은 1로 표기한다.)
*/


import java.util.Scanner;

public class CheckJumin {
    public static void main(String[] args) {
        int[] n = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
        int r = 0; // 연산한 결과를 담을 변수
        int check = 0; // 주민번호의 맨 끝자리를 담을 변수

        // 사용자한테 주민등록번호를 입력받습니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호를 입력해 주세요(하이픈 제외) ==> ");
        String jumin = sc.next();

        // 사용자가 입력한 주민번호의 맨 끝자리를 check에 저장
        check = Integer.parseInt(jumin.charAt(jumin.length() - 1) + "");

        // 검증번호를 통해 올바른 주민등록번호인지 확인합니다.
        for (int i = 0; i < jumin.length() - 1; i++) {
            r = r + n[i] * Integer.parseInt(jumin.charAt(i) + "");
        }

        // 계산된 결과에 11로 나눈 나머지를 구합니다.
        r = r % 11;
        // 11에서 그 결과를 빼줍니다.
        r = 11 - r;

        if (r == 10) {
            r = 0;
        } else if (r == 11) {
            r = 1;
        }

        if (r == check) {
            System.out.println("올바른 주민등록번호입니다.");
        } else {
            System.out.println("올바른 주민등록번호가 아닙니다.");
        }

        System.out.println("검증번호 출력 => " + check);
    }
}
