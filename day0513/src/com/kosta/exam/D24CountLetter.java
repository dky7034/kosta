package com.kosta.exam;

import java.util.Scanner;

public class D24CountLetter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 26개의 정수를 저장할 수 있는 배열 count 선언, 생성
		// 알파벳 a부터 Z까지의 문자 빈도수를 저장하기 위한 배열
		int[] count = new int[26];
		
		// 사용자에게 문자열을 입력받아 buffer 변수에 저장.
		// nextLine(); => 공백을 포함한 한 줄 전체를 읽음.
		System.out.println("문자열을 입력하시오 ==> ");
		String buffer = sc.nextLine(); // nextLine => 공백문자 입력 가능
		
		// 각 문자가 등장하는 횟수를 계산
		// 문자열의 길이만큼 반복.
		// 65 => A / 97 => a
		// ch - 'a' 연산자를 통해 a를 0, b를 1, ... z를 25로 매핑
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
