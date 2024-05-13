package com.kosta.exam;

import java.util.Scanner;

public class D24CountLetter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 26개의 정수를 저장할 수 있는 배열 count 선언, 생성
		int[] count = new int[26];
		
		System.out.println("문자열을 입력하시오 ==> ");
		String buffer = sc.nextLine(); // nextLine => 공백문자 입력 가능
		
		// 각 문자가 등장하는 횟수를 계산
		// 문자열의 길이만큼 반복.
		for (int i=0; i<buffer.length(); i++) {
			char ch = buffer.charAt(i);
			count[ch - 'a']++;
		}
		
		// 배열에 저장된 횟수를 출력하는 반복 루프
		for(int i=0; i<count.length; i++) {
			System.out.printf("%c ==> %d\n", (char)('a' + i), count[i]);
			
		}
		
		
		
	}

}
