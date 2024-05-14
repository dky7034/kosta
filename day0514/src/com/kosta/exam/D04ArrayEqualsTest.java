package com.kosta.exam;

public class D04ArrayEqualsTest {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {1, 2, 3, 4, 5};

		if (a == b) {
			System.out.println("배열의 내용이 일치합니다.");
		} else {
			System.out.println("배열의 내용이 일치하지 않습니다.");
		}
		
	}

}
