package com.kosta.exam01;

import java.util.Scanner;

// 사용자에게 아이디와 암호를 입력받아서
// 올바른지 판별하는 프로그램
// ex) 아이디: "kosta", 암호: "1234"
public class EqualsTest03 {
    public static void main(String[] args) {
        String id, pwd;
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력 ==> ");
        id = sc.next();
        System.out.print("암호를 입력 ==> ");
        pwd = sc.next();

        // equalsIgnoreCase() 메서드는 대소문자를 무시하고 내용을 비교하는 데 사용.
        // toLowerCase() 메서드는 문자열을 소문자로
        if (id.toLowerCase().equals("kosta") && pwd.toLowerCase().equals("1234")) {
        System.out.println("어서오세요!");
        } else {
            System.out.println("아이디와 암호를 확인하세요.");
        }
    }
}
