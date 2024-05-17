package com.kosta.exam18;

class BankAccount {
    // 잔액을 표시하는 변수
    private int balance;
    
    // 메서드
    // 입금 메서드
    public void deposit(int amount) {
        System.out.println("입금액: " + amount);
        balance += amount;
        System.out.println("입금 후 잔액: " + balance);
    }
    // 출금 메서드
    public void withdraw(int amount) {
        System.out.println("출금액: " + amount);
        if (amount > balance) {
            System.out.println("잔액보다 많은 금액을 출금할 수 없습니다...");
            return;
        } else if (balance < 0) {
            System.out.println("마이너스 통장에서는 출금할 수 없습니다...");
            return;
        }
        balance -= amount;
        System.out.println("출금 후 잔액: " + balance);
    }
    // 현재 잔액을 출력하는 메서드
    public void printBalance() {
        System.out.println("현재 잔액: " + balance);
    }
    // 현재 잔액에 대하여 연 7.5%의 이자를 계산하여 추가하는 메서드
    public void addInterest() {
        double result = balance *= 1.075;
        System.out.println("이자를 추가한 잔액: " + result);
    }
    // getter and setter
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

}

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();

        System.out.println();

        b1.setBalance(0);
        b2.setBalance(50);
        System.out.print("b1에서 60 출금 ==> ");
        b1.withdraw(60);
        System.out.print("b2에서 30 출금 ==> ");
        b2.withdraw(30);
        System.out.println();
        System.out.println("b1의 잔고를 출력합니다..");
        b1.printBalance();
        System.out.println("b2의 잔고를 출력합니다..");
        b2.printBalance();

        System.out.println();
        System.out.println("b1에 7.5%의 이자율을 추가한 잔고를 출력합니다..");
        b1.addInterest();
        System.out.println("b2에 7.5%의 이자율을 추가한 잔고를 출력합니다..");
        b2.addInterest();


    }
}
