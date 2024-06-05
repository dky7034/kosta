package com.kosta.exam01;

// 필요한 라이브러리 임포트
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

// JFrame을 상속받아 GUI를 구성하는 클래스 정의
public class ListStudentGUI_JTextArea extends JFrame {
    JTextArea jta; // 텍스트 영역을 선언

    // 생성자
    public ListStudentGUI_JTextArea() {
        jta = new JTextArea(); // JTextArea 객체 생성
        JScrollPane jsp = new JScrollPane(jta); // JTextArea를 포함하는 JScrollPane 객체 생성
        JPanel p = new JPanel(); // JPanel 객체 생성
        p.setLayout(new FlowLayout(FlowLayout.RIGHT)); // JPanel의 레이아웃 설정
        JButton btnRead = new JButton("읽어오기"); // "읽어오기" 버튼 생성
        p.add(btnRead); // 패널에 버튼 추가

        add(jsp, BorderLayout.CENTER); // JScrollPane을 프레임의 중앙에 추가
        add(p, BorderLayout.SOUTH); // 패널을 프레임의 아래쪽에 추가

        setSize(400, 300); // 프레임 크기 설정
        setVisible(true); // 프레임을 보이도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램 종료

        // 버튼에 액션 리스너 추가
        btnRead.addActionListener(new ActionListener() {
            // 버튼 클릭 시 실행될 SQL 쿼리 문자열 선언
            String sql = "select * from student";
            Connection conn = null; // DB 연결 객체 선언
            Statement stmt = null; // SQL 명령 실행 객체 선언
            ResultSet rs = null; // SQL 결과 저장 객체 선언

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // JDBC 드라이버 로드
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    // DB 연결 설정
                    conn = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:XE",
                            "c##madang",
                            "madang"
                    );
                    // SQL 명령 실행 객체 생성
                    stmt = conn.createStatement();
                    // SQL 쿼리 실행 및 결과 저장
                    rs = stmt.executeQuery(sql);

                    // 결과 집합을 반복하며 JTextArea에 추가
                    while (rs.next()) {
                        String name = rs.getString(1); // 첫 번째 열 값 (이름) 가져오기
                        int kor = rs.getInt(2); // 두 번째 열 값 (국어 점수) 가져오기
                        int eng = rs.getInt(3); // 세 번째 열 값 (영어 점수) 가져오기
                        int math = rs.getInt(4); // 네 번째 열 값 (수학 점수) 가져오기
                        String row = name + ", " + kor + ", " + eng + ", " + math; // 행 데이터 문자열 생성
                        jta.append(row + "\n"); // JTextArea에 행 데이터 추가
                    }

                } catch (Exception exception) {
                    throw new RuntimeException(exception); // 예외 발생 시 런타임 예외 던지기
                } finally {
                    // 리소스 해제
                    try {
                        if (rs != null) {
                            rs.close(); // ResultSet 닫기
                        }
                        if (stmt != null) {
                            stmt.close(); // Statement 닫기
                        }
                        if (conn != null) {
                            conn.close(); // Connection 닫기
                        }
                    } catch (Exception ex) {
                        System.out.println("예외 발생: " + ex.getMessage()); // 예외 메시지 출력
                    }
                }
            }
        });

    }

    // 메인 메서드
    public static void main(String[] args) {
        new ListStudentGUI_JTextArea(); // GUI 인스턴스 생성 및 표시
    }
}
