package com.kosta.exam01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JFrame은 윈도우를 생성함(윈도우 타이틀, 닫기 버튼, 최소화/최대화 버튼 등을 포함)
public class JCheckBoxTest04 extends JFrame {
    // 결과를 출력할 JLabel 컴포넌트 선언(텍스트나 이미지를 표현하는 데 사용되는 Swing 컴포넌트)
    JLabel result;
    // 체크박스에 표시될 문자열 배열 선언
    String[] arr = {"사과", "포도", "수박", "바나나", "오렌지"};
    // 문자열 배열이 길이와 동일한 길이의 JCheckBox 배열 선언
    JCheckBox[] jcb = new JCheckBox[arr.length];

    // 메서드
    // 체크박스 선택 상태를 확인하는 메서드
    public void checkedList() {
        // 선택된 항목을 저장할 문자열 변수 초기화
        // 나중에 JLabel(result)에 추가
        String r = "";
        // 모든 체크박스를 반복문으로 순회
        for (int i = 0; i < jcb.length; i++) {
            // 체크박스가 선택되었는지 확인
            if (jcb[i].isSelected()) {
                // 선택된 체크박스의 텍스트를 결과 문자열에 추가
                r += jcb[i].getText() + ", ";
            }
        }
        // 어떤 체크박스도 선택되지 않은 경우
        if (r.equals("")) {
            r = "선택해 주세요.";
        } else {
            // 마지막 ", "를 제거
            // substring(시작 인덱스, 끝 인덱스) 메서드
            // '시작 인덱스'부터 '끝 인덱스 -1'(끝 인덱스에 해당하는 문자는 포함하지 않음)
            // 에 해당하는 문자만을 포함(포함되지 않은 부분 제외)
            // ex) "[0]'사'[1]'과'[2]','[3]' '" -> 0 ~ 4까지 총 4개의 인덱스:
            // substring(0, 4-2(=2)) 메서드는 인덱스 0과 1에 해당하는 문자만 포함하므로
            // "사과"가 됨.
            System.out.println("substring() 메서드 전: " + r);
            r = r.substring(0, r.length() - 2);
            System.out.println("substring() 메서드 후: " + r);
            r += "를(을) 선택하셨습니다.";
        }
        // 결과 레이블에 결과 문자열 설정
        result.setText(r);
    }

    // 생성자
    public JCheckBoxTest04() {
        // FlowLayout으로 레이아웃을 설정
        // 컴포넌트들의 레이아웃(구성, 배열하는 것을 의미)을 관리하는 레이아웃 매니저 중 하나
        setLayout(new FlowLayout());
        // 문자열 배열 길이만큼 반복
        for (int i = 0; i < arr.length; i++) {
            // 배열의 각 항목에 대해 JCheckBox를 생성
            jcb[i] = new JCheckBox(arr[i]);
            // 생성된 JCheckBox를 프레임에 추가
            add(jcb[i]);
            // JCheckBox에 ActionListener를 추가
            jcb[i].addActionListener(new ActionListener() {
                // ActionListener의 actionperforemd 메서드 구현
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 메서드 호출
                    // 체크박스 상태를 확인하는 메서드 호출
                    checkedList();
                }
            });
        }
        // 초기 메시지를 가진 JLabel을 생성
        result = new JLabel("선택해 주세요.");
        // JLabel(result)를 프레임에 추가
        add(result);
        // 프레임의 크기를 설정
        setSize(400, 300);
        // 프레임을 화면에 보이도록 설정
        setVisible(true);
        // 프레임의 닫기 버튼을 클릭할 때 프로그램이 종료되도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 메인 메서드 - 프로그램의 진입점(시작점)
    public static void main(String[] args) {
        // JCheckBoxTest04 객체 생성 - 생성자 호출
        new JCheckBoxTest04();
    }
}
