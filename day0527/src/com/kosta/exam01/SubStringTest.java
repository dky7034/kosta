package com.kosta.exam01;

public class SubStringTest {
    public static void main(String[] args) {
        String data = "hello java";
        String str1 = data.substring(1, 7); // ello j (마지막 인덱스는 포함 X)
        System.out.println(str1);

        String str2 = data.substring(1); // 인덱스 1부터 마지막 인덱스까지
        System.out.println(str2);

    }
}
