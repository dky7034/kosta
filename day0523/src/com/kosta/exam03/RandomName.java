package com.kosta.exam03;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

// 난수 연습
// 변시우, 임유나, 홍석영, 조영흔, 유요한, 이동준, 박성빈, 박준수, 김예은
// 이재원, 장동건, 최모래, 최가은, 박규희, 유현진, 공희상, 강동균
// 반 사람들 중에서 무작위로 한 명을 뽑아서 이름을 출력
public class RandomName {
    public static void main(String[] args) {
        // TreeSet에 저장
        TreeSet class_702 = new TreeSet();
        class_702.add("변시우");
        class_702.add("임유나");
        class_702.add("홍석영");
        class_702.add("조영흔");
        class_702.add("유요한");
        class_702.add("이동준");
        class_702.add("박성빈");
        class_702.add("박준수");
        class_702.add("김예은");
        class_702.add("이재원");
        class_702.add("장동건");
        class_702.add("최모래");
        class_702.add("최가은");
        class_702.add("박규희");
        class_702.add("유현진");
        class_702.add("공희상");
        class_702.add("강동균");

        System.out.print(class_702);
        System.out.println();

        // 배열에 저장
        String[] data = {"변시우", "임유나", "홍석영", "조영흔", "유요한", "이동준", "박성빈", "박준수", "김예은",
                "이재원", "장동건", "최모래", "최가은", "박규희", "유현진", "공희상", "강동균"};
        Random r = new Random();
        int n = r.nextInt(data.length);

        String name = "";
        for (int i = 0; i < 100; i++) {
            name = data[i % data.length];
        }

        System.out.println("--------------------------");
        System.out.println("*** 당첨자 ***");
        System.out.println(data[n]);

    }
}
