package com.kosta.exam;

import java.util.Scanner;

// 사용자한테 두 개의 정수를 입력받아 더하기하여 결과를 출력

public class D20_AddTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.print("정수 a를 입력해 주세요: ");
		a = sc.nextInt();
		System.out.print("정수 b를 입력해 주세요: ");
		b = sc.nextInt();
		
		int sum = a + b;
		System.out.println("sum = " + sum);
		System.out.println();
	}

}
