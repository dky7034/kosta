package com.kosta.exam;

public class D04ArrayEqualsTest {

	public static void main(String[] args) {
		
		int[] a = {1, 3, 3, 4, 5};
		int[] b = {1, 2, 3, 4, 5};

		// if (a == b) {
		// 	System.out.println("배열의 내용이 일치합니다.");
		// } else {
		// 	System.out.println("배열의 내용이 일치하지 않습니다.");
		// }
		
		// 두 개의 배열의 원소가 모두 동일한지 판별하는 프로그램을 작성해 봅니다.
		if (!(a.length == b.length)) {
			System.out.println("두 배열의 길이가 다릅니다.");
		} 

		int length = a.length;
		
		for (int i=0; i<length; i++) {
			if (!(a[i] == b[i])) {
				System.out.println("두 배열의 원소는 다릅니다.");
				return;
			}
		}

		System.out.println("두 배열의 원소는 모두 동일합니다.");

		


	}

}
