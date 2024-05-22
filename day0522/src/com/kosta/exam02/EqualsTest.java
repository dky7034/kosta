package com.kosta.exam02;

public class EqualsTest {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("홍길동", 20);

        System.out.println(p1);
        System.out.println(p2);

        // 객체 참조 변수는 값을 갖고 있는 것이 아니라
        // 값이 있는 객체, 즉 메모리를 참조하고 있기 때문에
        // p1이 참조하고 있는 객체와 p2가 참조하고 있는 객체가 서로 다릅니다.
        // 만약, 두 객체가 서로 동일한 속성값을 갖고 있는지 판별하려면
        // 자바의 제일 조상클래스(object)의 equals() 메서드를
        // 자신에게 맞도록 재정의(override)해야 합니다.
//        if (p1 == p2) {
//            System.out.println("같아요");
//        } else {
//            System.out.println("달라요");
//        }

        if (p1.equals(p2)) {
            System.out.println("같아요");
        } else {
            System.out.println("달라요");
        }
    }
}
