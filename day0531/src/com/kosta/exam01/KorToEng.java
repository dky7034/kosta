//package com.kosta.exam01;
//
//import javax.swing.*;
//import java.util.HashMap;
//
//// 텍스트를 입력합니다.
//// 몇 개의 단어를 영어로 변환합니다.
//public class KorToEng {
//    JTextArea jta01;
//    JTextArea jta02;
//
//    HashMap<String, String> dic;
//    public static String suffix[] = {"은", "는", "이", "가", "로"};
//
//    // 조사를 떼고 반환하는 메서드
//    public static String getRemoveSuffix(String kor) {
//        // 영어로
//        for (String s : suffix) {
//            if (kor.endsWith(s)) {
//                kor = kor.substring(0, kor.length() - s.length() - 1);
//                break;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new KorToEng();
//    }
//}
