package com.kosta.exam04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SayHello implements Runnable {

    @Override
    public void run() {
        while (true) {
            int count = 0;
            Date date = new Date();
            int year = date.getYear() + 1900;
            int month = date.getMonth() + 1;
            int day = date.getDate();
            int hour = date.getHours();
            int minute = date.getMinutes();
            int second = date.getSeconds();

            System.out.println(year + "년 " + month + "월 " + day + "일 " + hour + "시 "
                                + minute + "분 " + second + "초" + ", 안녕하세요?");
//            System.out.println(date + ", 안녕하세요?");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
//                System.out.println("안녕하세요?");
//                System.out.println(sdf.format(date.getTime()));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            count++;
            if (count == 100) {
                break;
            }
        }
    }
}
