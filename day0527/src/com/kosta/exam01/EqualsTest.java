package com.kosta.exam01;

import java.util.Scanner;

// 사용자에게 아이디와 암호를 입력받아서
// 올바른지 판별하는 프로그램
// ex) 아이디: "kosta", 암호: "1234"
public class EqualsTest {
    public static void main(String[] args) {
        String id, pwd;
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력 ==> ");
        id = sc.next();
        System.out.print("암호를 입력 ==> ");
        pwd = sc.next();

//        if (id == "kosta" && pwd == "1234") {
        if (id.equals("kosta") && pwd.equals("1234")) {
        System.out.println("어서오세요!");
        } else {
            System.out.println("아이디와 암호를 확인하세요.");
        }
    }
}
