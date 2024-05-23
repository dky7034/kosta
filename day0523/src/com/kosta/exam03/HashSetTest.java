package com.kosta.exam03;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet data = new HashSet();
        Set data2 = new HashSet();

        data.add(1);
        boolean f1 = data.add(1);
        System.out.println(f1);
        data.add(true);
        data.add("사과");

        data2.add(1);
        data2.add(2);
        data2.add(3);

        System.out.println(data);
        System.out.println();
        System.out.println(data2);
    }
}
