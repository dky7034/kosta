package com.kosta.exam01;

public class IndexOfContainsTest {
    public static void main(String[] args) {
        String data = "hello java hello oracle";
        // 정규표현식 사용
        if (data.matches(".*java.*")) {
            System.out.println("java를 포함하고 있습니다.");
        } else {
            System.out.println("java를 포함하고 있지 않습니다.");
        }
        //
        if (data.contains("java")) {
            System.out.println("java를 포함하고 있습니다.");
        } else {
            System.out.println("java를 포함하고 있지 않습니다.");
        }
        //
        if (data.indexOf("java") != -1) {
            System.out.println("java를 포함하고 있어요!");
        } else {
            System.out.println("java를 포함하고 있지 않습니다.");
        }

    }
}
