package com.kosta.exam17;

class BankAccount {
    private String name;
    private String account;
    private int balance;
    private double rate;

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    // 생성자
    public BankAccount(String name, String account, int balance, double rate) {
        this.name = name;
        this.account = account;
        this.balance = balance;
        this.rate = rate;
    }
    public BankAccount() {} // 기본생성자

    public BankAccount(String name) {
        this.name = name;
    }

    public BankAccount(String name, String account) {
        this.name = name;
        this.account = account;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public BankAccount(double rate) {
        this.rate = rate;
    }

}

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount("김김김", "1233456", 123456, 2.15);

        b1.setAccount("152182422");

        String account =  b1.getAccount();

        double rate = b2.getRate();

        System.out.println("account = " + account);
        System.out.println("rate = " + rate);


    }

}
