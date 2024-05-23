package com.kosta.exam03;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set data = new LinkedHashSet();
        data.add("된장찌개");
        data.add("백반");
        data.add("짬뽕");
        boolean f1 = data.add("김치찌개");
        boolean f2 = data.add("짬뽕");
        System.out.println(data);
        System.out.println(f1);
        System.out.println(f2);
    }
}
