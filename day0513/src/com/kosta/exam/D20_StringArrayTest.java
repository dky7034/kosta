package com.kosta.exam;

import java.util.Scanner;

public class D20_StringArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] data = new String[5];
		System.out.println("인생에 있어 중요하게 여기는 것을 차례로 말해주세요. => ");
		for (int i=0; i<data.length; i++)
		{
			System.out.printf("%d번째, 입력하세요 ==> ", i+1);
			data[i] = sc.next();
		}
		System.out.println("*** 결과 ***");
		
		for (int i=0; i<data.length; i++)
		{
			System.out.println(data[i]);
		}
	}
}
