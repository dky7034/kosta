package com.kosta.exam28;

public class FamilyTest {

    public static void main(String[] args) {
        // static 키워드가 붙어있는 멤버변수는 객체와 무관하게 사용할 수 있습니다.
        // 클래스명으로 접근합니다.
        Family.addr = "서울시 종로구 관철동";
        System.out.println(Family.addr);
        
        // Family 객체 생성
        Family f1 = new Family("홍길동", 20);
        Family f2 = new Family("홍짱구", 7);

        System.out.println("============================");
        System.out.println("이름: " + f1.getName());
        System.out.println("나이: " + f1.getAge());
        System.out.println(f1.addr);

        // addr 수정
        Family.addr = "서울시 서초구 방배동";

        System.out.println("============================");
        System.out.println("이름: " + f2.getName());
        System.out.println("나이: " + f2.getAge());
        System.out.println(f2.addr);
        System.out.println(f1.addr);

        System.out.println("============================");
        // 클래스 메서드는 클래스명으로 호출하거나,
        Family.pro();
        // 객체를 생성하여 호출할 수 있습니다.
        f1.pro();

        
    }

}
