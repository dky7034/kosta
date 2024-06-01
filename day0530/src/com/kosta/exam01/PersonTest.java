package com.kosta.exam01;

public class PersonTest {
    public static void main(String[] args) {
        Person kim = new Person("김김김");
        Person lee = new Person("이이이");
        Person hong = new Person("홍홍홍");

        lee.start();
        kim.start();
        hong.start();
    }
}
