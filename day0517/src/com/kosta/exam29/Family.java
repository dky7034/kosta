package com.kosta.exam29;

public class Family {
    private String name;
    private int age;
    public static String addr;

    public static void pro() {
        // 클래스 메서드는 객체 없이도 동작하는 메서드이므로,
        // 객체를 생성해야만 확보되는 메모리 영역인 name과 age에는 접근할 수 없습니다.
        // static 메서드에서는 static 멤버에만 접근할 수 있습니다.
//        name = "홍길동";
//        age = 20;
        System.out.println("pro입니다...");
    }

}
