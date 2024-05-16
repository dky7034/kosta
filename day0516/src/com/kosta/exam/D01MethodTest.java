package com.kosta.exam;

public class D01MethodTest {
    
    public static String getFirstName(String[] name, int[] score) {
        String result = "";
        // 메서드의 내용을 구체화
        // 점수가 가장 높은 학생의 이름을 반환
        int max = score[0];
        for (int i=1; i<name.length; i++) {
            if (max < score[i]) {
                max = score[i];
                result = name[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] name = {"홍길동", "이순신", "유관순", "김유신", "강감찬"};
        int[] score = {80, 90, 95, 70, 60};
        System.out.println(getFirstName(name, score));
    }

    
}