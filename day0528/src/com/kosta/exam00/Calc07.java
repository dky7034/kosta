package com.kosta.exam00;

// 프로그램 실행 시 두 개의 정수를 전달받아 나누기한 결과를 출력
// java Calc 4 2
public class Calc07 {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int div = a / b;
            System.out.println("나누기 결과: " + div);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누기할 수 없습니다.");
        } catch (Exception e) {
            System.out.println("나누기할 두 개의 정수를 확인해 주세요.");
        } finally {
            System.out.println("작업 종료");
        }
    }
}

/*
* finally {}
* ==> 정상 동작하거나 예외가 발생하거나 반드시 수행하고자 하는 명령어들을 작성해 줍니다.
*/