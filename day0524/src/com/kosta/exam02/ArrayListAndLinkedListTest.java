package com.kosta.exam02;

import java.util.ArrayList;

public class ArrayListAndLinkedListTest {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();

        data.add("사과");
        data.add("수박");
        data.add("딸기");

        System.out.println(data);

        data.add(2, "포도");

        System.out.println(data);

        data.remove(1);

        System.out.println(data);
    }
}
