package com.kosta.exam;

public class D03 {

	public static void main(String[] args) {
		
		int[] numbers = new int[5];
        
        for(int i=0; i<5; i++) { // 0부터 4까지 1씩 증가
            numbers[i] = i+1; // 인덱스 0일 때, 1 저장
        }

        for(int i : numbers) {
            System.out.print("i: " + i + " ===> ");
            System.out.println(numbers[i]);
        }
		
	}

}
