package com.kosta.exam;

import java.util.Iterator;
import java.util.Scanner;

// 5명의 정수를 입력받아
// 최고값과 그 때의 인덱스를 구하여 출력
// 배열중에 가장 큰 값 찾기
// 1) 배열의 맨 첫 번째 요소를 max에 저장한다.
// 2) 나머지 배열의 요소를 모두 max와 비교하여 그 값이 max보다 크다면
//	  그 값을 max에 저장한다.
public class D21_MaxTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];
		for (int i=0; i<score.length; i++) {
			System.out.printf("%d번째 학생의 점수 입력 => ", i+1);
			score[i] = sc.nextInt();
		}
		
		int max;
		int maxPosition = 0;
		max = score[0];
		
		for (int i=1; i<score.length; i++) {
			if (score[i] > max) {
				max = score[i];
				maxPosition = i;
			}
		}
		
		System.out.println("최대값: " + max);
		System.out.println("최대값의 인덱스: " + maxPosition);
		
		
		
	}

}
