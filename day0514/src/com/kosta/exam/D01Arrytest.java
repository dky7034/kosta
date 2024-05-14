package com.kosta.exam;

public class D01Arrytest {

	public static void main(String[] args) {
		
		int[] data = {10, 20, 30, 40, 50};
		
//		for (int i=0; i<5; i++) { // i => 0, 1, 2, 3, 4
//			System.out.println(data[i]);
//			
//		}
		
		// for-each 반복문
		// 배열의 요소만큼 반복 실행시키는 문장
		// for(  자료형 변수이름  :  배열이름  ) {}
		for (int x : data) {
			System.out.println(x);
		}
		
	}

}
