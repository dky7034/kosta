package com.kosta.exam02;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLinkedListTest2 {
    public static void main(String[] args) {
        LinkedList<String> data = new LinkedList<>();

        data.add("사과");
        data.add("수박");
        data.add("딸기");

        System.out.println(data);

        data.add(1, "포도");

        System.out.println(data);

        data.remove(2);

        System.out.println(data);
    }
}
