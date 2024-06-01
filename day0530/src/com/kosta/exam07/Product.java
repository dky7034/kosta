package com.kosta.exam07;

import java.util.Random;

// 생산자와 소비자가 공유할 자원인 "제품" 클래스를 만듭니다.
// 새로운 정수를 제품이라고 생각합니다.
public class Product {
    // 제품을 위한 정수형 변수를 선언합니다.
    // 생산자는 이 정수를 계속해서 새롭게 만들어주고,
    // 소비자는 이 정수를 계속해서 가져다 쓰도록 합니다.
    int number;

    // 새 제품이 생산되었는지 판별하기 위한 변수
    // 생산자는 새 제품을 생산한 다음 isNew에 true를 저장하고,
    // 소비자는 제품을 소비한 후에 isNew에 false를 저장합니다.
    boolean isNew = false; // 초기값 설정

    // 생산자가 새 제품을 생산하기 위한 메서드
    // 생산자가 새 제품을 생산하는 동안
    // 소비자의 접근을 막아야 하므로 임계영역 설정을 위해 synchronized 키워드를 붙입니다.
    public synchronized void makeNumber() {
        try {
            // 제품이 소비될 때까지 기다립니다.
            while (isNew) {
                wait();
            }

            // 새 제품을 만듭니다.
            Random r = new Random();
            number = r.nextInt(100) + 1; // 1 ~ 100까지 새로운 수 생성

            // 생산된 제품 출력
            System.out.println("생산자가 생산함 ==> " + number);

            // 새 제품을 만들었다고 표시합니다.
            isNew = true;

            // 대기중인 소비자를 깨워줍니다.
            notify();

        } catch (InterruptedException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

    }

    // 소비자가 사용하는 메서드
    // 소비자가 제품을 소비하는 동안
    // 생산자의 접근을 막아야 하므로 임계영역 설정을 위해 synchronized 키워드를 붙입니다.
    public synchronized int useNumber() {
        int n = 0;

        try {
            // 새로운 제품을 생산할 때까지 기다립니다.
            while (!isNew) {
                wait();
            }

            // 생산된 제품(number)을 소비합니다(저장)
            n = number;

            // 제품을 소비했음을 출력
            System.out.println("소비자가 소비함 ==> " + n);
            System.out.println("=====================");

            // 제품을 소비한 후 isNew를 false로 설정합니다.
            isNew = false;

            // 대기중인 생산자를 깨워줍니다.
            notify();

        } catch (InterruptedException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        return n;
    }
}
