package com.kosta.exam02;

public class PersonTest {
    public static void main(String[] args) {
        Person kim = new Person("김김김");
        Person lee = new Person("이이이");
        Person hong = new Person("홍홍홍");

        lee.setPriority(1);
        kim.setPriority(1);
        hong.setPriority(Thread.MAX_PRIORITY);
        // 에러: "스레드"의 맥스를 사용해야 함
//        hong.setPriority(MAX_PRIORITY);

        lee.start();
        kim.start();
        hong.start();

    }
}
// 스레드의 우선순위 설정
// 필요하다면 스레드의 우선순위를 설정할 수 있습니다.
// 단, 우선순위 설정이 실행의 순서를 보장하지는 않습니다.
// setPriority(int newPriority);
// newPriority의 범위는 1(Thread.MIN_PRIORITY) ~ 10(Thread.MAX_PRIORITY)입니다.
