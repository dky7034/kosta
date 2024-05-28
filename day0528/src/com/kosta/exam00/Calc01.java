package com.kosta.exam00;

// 프로그램 실행 시 두 개의 정수를 전달받아 나누기한 결과를 출력
// java Calc 4 2
public class Calc01 {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int div = a / b;
            System.out.println("나누기 결과: " + div);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("나누기할 두 수를 전달해 주세요.");
        }
    }
}
