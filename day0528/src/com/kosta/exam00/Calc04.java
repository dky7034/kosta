package com.kosta.exam00;

// 프로그램 실행 시 두 개의 정수를 전달받아 나누기한 결과를 출력
// java Calc 4 2
public class Calc04 {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int div = a / b;
            System.out.println("나누기 결과: " + div);
        } catch (Exception e) {
            System.out.println("나누기할 두 개의 정수를 확인해 주세요.");
//        } catch (ArithmeticException e) {
//            System.out.println("0으로 나누기할 수 없습니다.");
//        }
        }
    }
}
/*
* 12번줄의 catch(Exception e)가 이미 모든 예외 상황을 처리하기 때문에
* 13번줄의 catch(ArithmeticException e)에 도달할 수 없습니다.
* 이처럼, catch절을 여러 개 사용할 경우에는
* 자식의 catch절이 먼저 오도록 작성해야 합니다.
*/
