/*
 * 5명 학생의 이름, 점수를 입력받아서
 * 최고점수 학생의 이름을 출력
 */


package com.kosta.exam;

import java.util.Scanner;

public class D22 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[5];
		String[] name = new String[5];
		
		int n = score.length;
		
		for (int i = 0; i < n; i++) {
			System.out.print("학생의 이름을 입력해 주세요 => ");
			name[i] = sc.next();
			System.out.print("학생의 점수를 입력해 주세요 => ");
			score[i] = sc.nextInt();
		}
		
//		System.out.print("학생의 점수를 입력해 주세요 => ");
//		for (int i = 0; i < score.length; i++) {
//			score[i] = sc.nextInt();
//		}
//		// 학생 이름, 점수 출력
//		for (int i=0; i<score.length; i++) {
//			System.out.printf("%5s", name[i]);
//		}
//		System.out.println();
//		for (int i=0; i<score.length; i++) {
//			System.out.printf("%5d", score[i]);
//		}
		
		System.out.println();
		
		// int max, maxIndex 사용
		// index 0~4
		// name.length == 5
		int max, maxIndex;
		max = score[0];
		maxIndex = 0;
		for (int i = 1; i < n; i++) {
			if (max < score[i]) {
				max = score[i];
				maxIndex = i;
			}
		}
		
		System.out.println("최고점수 => " + max);
		System.out.println("최고점수 학생 => " + name[maxIndex]);
		
	}

}
