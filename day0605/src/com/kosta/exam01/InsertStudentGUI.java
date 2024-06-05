package com.kosta.exam01;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudentGUI extends JFrame {
    public static void main(String[] args) {
        String name;
        int kor, eng, math;
        Scanner sc = new Scanner(System.in);
        System.out.print("학생의 이름 ==> ");
        name = sc.next();
        System.out.print("국어 점수 ==> ");
        kor = sc.nextInt();
        System.out.print("영어 점수 ==> ");
        eng = sc.nextInt();
        System.out.print("수학 점수 ==> ");
        math = sc.nextInt();

        Connection conn = null;
        Statement stmt = null;

        try {
            String sql = "insert into student values('"+ name + "', "+ kor +", "+ eng +", "+ math +")";

            // 1. jdbc 드라이버를 메모리로 로드한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. DB 서버에 연결한다. (Oracle 사용)
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "c##madang", "madang"
            );

            // 3. DB 명령어 실행 담당 객체를 생성한다.
            stmt = conn.createStatement();

            // 4. DB 명령어를 실행한다.
            int re = stmt.executeUpdate(sql);

            if (re == 1) {
                System.out.println("학생의 정보를 추가하였습니다.");
            } else {
                System.out.println("학생 정보 추가에 실패하였습니다.");
            }

        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
        }
    }
}
