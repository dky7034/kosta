package com.kosta.exam;

import java.util.Scanner;

public class HomeWork02 {

    private static String[] zodiacHours = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
    private static String[] zodiacInterpretation = {
        "천귀", "천액", "천권", "천파", "천인", "천문", "천복", "천고", "천역", "천간(남편복, 바람끼)", "천수", "천명"
    };
    private static int[] hourRanges = {23, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("생년 (Year of Birth): ");
        int year = scanner.nextInt();

        System.out.print("생월 (Month of Birth): ");
        int month = scanner.nextInt();

        System.out.print("생일 (Day of Birth): ");
        int day = scanner.nextInt();

        System.out.print("생시 (Hour of Birth in 24-hour format): ");
        int hour = scanner.nextInt();

        String zodiacSign = getZodiacSign(hour);
        String interpretation = getZodiacInterpretation(hour);

        System.out.println("생년: " + year + ", 생월: " + month + ", 생일: " + day + ", 생시: " + hour);
        System.out.println("당신의 사주 해석: " + zodiacSign + " (" + interpretation + ")");
        
        scanner.close();
    }

    private static String getZodiacSign(int hour) {
        for (int i = 0; i < hourRanges.length; i++) {
            int start = hourRanges[i];
            int end = (i == hourRanges.length - 1) ? 24 : hourRanges[i + 1];
            if (hour >= start && hour < end) {
                return zodiacHours[i];
            }
        }
        return "Unknown";
    }

    private static String getZodiacInterpretation(int hour) {
        for (int i = 0; i < hourRanges.length; i++) {
            int start = hourRanges[i];
            int end = (i == hourRanges.length - 1) ? 24 : hourRanges[i + 1];
            if (hour >= start && hour < end) {
                return zodiacInterpretation[i];
            }
        }
        return "Unknown";
    }
}
