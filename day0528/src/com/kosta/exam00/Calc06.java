package com.kosta.exam00;

// 프로그램 실행 시 두 개의 정수를 전달받아 나누기한 결과를 출력
// java Calc 4 2
public class Calc06 {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int div = a / b;
            System.out.println("나누기 결과: " + div);
            System.out.println("작업 종료");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누기할 수 없습니다.");
        } catch (Exception e) {
            System.out.println("나누기할 두 개의 정수를 확인해 주세요.");
        }
    }
}

/*
* 만약 정상적으로 동작하는 경우에는
* try 안의 마지막 문장을 동작하여 "작업 종료"를 출력합니다.
* 그러나 예외 상황이 되면 해당 catch절을 수행하고
* try 안의 다음 명령을 동작하지 않습니다.
* 즉, 예외 상황이 되면 "작업 종료"를 출력하지 않습니다.
* */