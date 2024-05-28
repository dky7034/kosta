package com.kosta.exam02;

import java.util.Scanner;

// 예외 클래스
class NegativeBalanceException extends Exception {
    public NegativeBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    // 잔액을 나타내는 필드
    int balance = 0;

    // 입금을 나타내는 메서드
    public void deposit(int inputAmount) {
        if (inputAmount > 0) {
            balance += inputAmount;
            System.out.println("입금이 완료되었습니다.");
            System.out.println("입금 후 잔액 ==> " + balance + "원");
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    // 출금을 나타내는 메서드
    public void withdraw(int outputAmount) throws NegativeBalanceException {
        if (balance < outputAmount) {
            throw new NegativeBalanceException("인출 금액이 잔액보다 클 수 없습니다. 현재 잔액은 " + balance + "원입니다.");
        } else if (outputAmount > 0 && outputAmount <= balance) {
            balance -= outputAmount;
            System.out.println("출금 후 잔액 ==> " + balance + "원");
        } else {
            System.out.println("출금 금액은 0보다 커야 합니다.");
        }
    }
}

public class BankAccountTest {
    public static void main(String[] args) {
        try {
            boolean exit = false;
            // BankAccount 객체 생성
            BankAccount account = new BankAccount();
            Scanner sc = new Scanner(System.in);

            while (!exit) {
                System.out.println("메뉴를 선택해 주세요.");
                System.out.print("1. 입금 / 2. 출금 / 3. 취소 ==> ");
                int menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        System.out.print("입금하실 금액을 입력해 주세요 ==> ");
                        account.deposit(sc.nextInt());
                        break;
                    case 2:
                        System.out.print("출금하실 금액을 입력해 주세요 ==> ");
                        try {
                            account.withdraw(sc.nextInt());
                        } catch (NegativeBalanceException e) {
                            System.out.println("예외 발생: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("취소를 선택하셨습니다. 프로그램을 종료합니다.");
                        exit = true;
                        break;
                    default:
                        System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해 주세요.");
                        break;
                }
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
