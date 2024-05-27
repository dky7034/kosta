package com.kosta.exam01;

import java.util.Scanner;

// 사용자한테 이메일을 입력받아서
// 올바른 이메일 형식인지 판별하는 프로그램
// ex) tiger@naver.com
public class CheckEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이메일을 입력해 주세요 ==> ");
        String email = sc.next();

        // 정규표현식 사용
        String regex = "^[A-zA-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]+";

        if (email.matches(regex) != true) {
            System.out.println("올바른 이메일 형식이 아닙니다.");
        } else {
            System.out.println("올바른 이메일 형식입니다.");
        }

    }
}
