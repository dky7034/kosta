package com.kosta.exam03;

import java.util.ArrayList;

public class ArrayListTeset {
    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        data.add("된장찌개");
        data.add("돈까스");
        data.add("냉면");
        data.add("김치찌개");
        data.add("냉면");
        data.add(100);

        System.out.println(data);

        // List는 인덱스에 의해 데이터에 접근합니다. (배열처럼)
        // 출력을 위해 저장된 Object 타입을 형변환합니다.
        String food = (String) data.get(0);
        int qty = (Integer) data.get(5);
        System.out.println(food);
        System.out.println(qty);
    }
}
