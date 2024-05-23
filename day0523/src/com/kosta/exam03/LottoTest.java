package com.kosta.exam03;

import java.util.Random;
import java.util.TreeSet;

// 이번주에 구입할 로또 번호를 생성
// 로또 번호는 1 ~ 45까지의 숫자, 중복 없이 6개
public class LottoTest {
    public static void main(String[] args) {
        Random random = new Random();

        TreeSet lotto = new TreeSet();

        for (int i = 0; ; i++) {
            int number = random.nextInt(45) + 1;
            lotto.add(number);
            if (lotto.size() >= 6) {
                break;
            }
        }
        System.out.println(lotto.size());
        System.out.println(lotto);

        long data = System.currentTimeMillis();
        System.out.println(data);

    }
}
