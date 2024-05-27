package com.kosta.hw240527;

import java.util.Scanner;

public class Hw01 {
    public static void main(String[] args) {
        // 사용자한테 문장을 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 => ");
        String str = sc.nextLine(); // 공백문자를 포함하여 문장을 입력받음

        System.out.println(str);

        // 입력한 모든 문자의 개수 구하기
//        String[] arr = str.split("");
//        System.out.println("총 입력한 문자 수 출력: " + arr.length);
        char[] arr2 = str.toCharArray();
        System.out.println(arr2.length);
        String str1 = "";
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
            str1 += arr2[i];
        }
        System.out.println();
        System.out.println("================================");

        // 입력받은 문장을 거꾸로 출력
        String str2 = "";
        for (int i = arr2.length - 1; i >= 0; i--) {
            System.out.print(arr2[i]);
            str2 += arr2[i];
        }
        System.out.println();
        System.out.println("================================");

        // 입력받은 값이 앞 뒤가 같은 문자(회문)인지 판별하는 프로그램을 작성
        boolean flag = true;
        for (int i = 0; i < arr2.length/2; i++) {
            if (!(arr2[i] == arr2[arr2.length-1-i])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("회문입니다.");
        } else {
            System.out.println("회문이 아닙니다.");
        }
    }
}
