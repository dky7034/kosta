package com.kosta.exam01;

// 어떤 사람의 이메일을 입력받아서
// 아이디만 추출하여 출력하는 프로그램을 작성해 봅시다.
import java.util.Scanner;

public class IndexOfSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이메일을 입력해 주세요 ==> ");
        String email = sc.next();
        String emailExam = "tiger@naver.com";

        String id = email.substring(0, email.indexOf("@"));
        System.out.println(id);

    }
}
