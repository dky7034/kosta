package com.kosta.exam03;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
    public static void main(String[] args) {
        // 한 사람의 이름, 주소, 전화번호를 리스트에 저장
        List<String> data = new ArrayList<>();

        data.add("홍길동");              // 이름 저장
        data.add("서울시 종로구 종로2가"); // 주소 저장
        data.add("010-1111-1111");      // 전화번호 저장

        // 위 코드의 경우
        // 이 사람의 전화번호를 가져오려면
        // 전화번호가 리스트의 세 번째 요소(인덱스 2)에 있다는 것을 알아야 합니다.
        // 이는 종종 헷갈릴 수 있습니다.

        // 각 요소의 데이터가 어떤 의미를 가지고 있을 때,
        // 인덱스를 사용해 접근하는 방식보다 키(key)를 사용해 접근하는 것이
        // 더 직관적이고 이해하기 쉽습니다.

        // 이러한 경우에 map을 사용하는 것이 좋습니다.
    }
}
