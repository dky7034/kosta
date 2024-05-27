package com.kosta.exam01;

import java.util.Scanner;

public class CheckJumin03 {
    public static void main(String[] args) {
        int[] n = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
        int r = 0; // 연산한 결과를 담을 변수
        int check = 0; // 주민번호의 맨 끝자리를 담을 변수

        // 사용자한테 주민등록번호를 입력받습니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호를 입력해 주세요(하이픈 포함) ==> ");
        String jumin = sc.next();

        // 주민등록번호가 올바르게 입력되었는지 판별
        // *** 정규표현식 사용 ***
        // 하이픈(-)을 기준으로 앞에는 6자리 숫자가 오고, 뒤에는 7자리 숫자가 와야 합니다.
//        String regex = "[0-9]{6}-[0-9]{7}";
        String regex = "||d{6}-||d{7}";
        if(jumin.matches(regex) != true) {
            System.out.println("올바른 주민등록번호 형식이 아닙니다.");
            return;
        }

        // 하이픈 제거
        jumin = jumin.replace("-", "");

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
