/**
 * 
여기 Java 프로그램은 생년, 생월, 생일, 생시를 입력받아 해당 시간에 따른 사주풀이를 출력하는 코드입니다. 이 프로그램은 이미지에 있는 정보를 바탕으로 작성되었습니다.
프로그램 설명
맵핑 배열 정의: zodiacHours와 zodiacInterpretation 배열은 각각 한국의 12지신과 그 해석을 저장합니다. hourRanges는 각 시간대의 시작 시간을 저장합니다.
입력 처리: 프로그램은 사용자로부터 생년, 생월, 생일, 생시를 입력받습니다.
사주 및 해석 계산: getZodiacSign과 getZodiacInterpretation 메서드는 입력된 시간을 바탕으로 적절한 12지신과 해석을 결정합니다.
출력: 프로그램은 입력된 생년월일시와 그에 따른 사주 해석을 출력합니다.
 * 
 */
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
/*
코드 설명
zodiacHours 배열: 12지신의 시간을 저장합니다.
zodiacInterpretation 배열: 각 시간대에 해당하는 사주 해석을 저장합니다.
hourRanges 배열: 각 시간대의 시작 시간을 저장합니다.
getZodiacSign 메서드: 입력된 시간을 기준으로 해당하는 12지신을 반환합니다.
getZodiacInterpretation 메서드: 입력된 시간을 기준으로 해당하는 사주 해석을 반환합니다.
이 프로그램을 실행하면, 생년월일시를 입력받아 사주풀이를 출력해줍니다. 프로그램의 구조는 기본적인 배열과 반복문을 사용하여 시간대에 맞는 사주를 결정합니다. 필요에 따라 해석을 더 자세히 조정할 수 있습니다.
 */
