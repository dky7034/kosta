package com.kosta.exam01;

import java.sql.*;
import java.util.Scanner;

// 사용자한테 이름을 입력받아
// 그 이름에 해당하는 학생의 정보를 조회하여
// 출력하는 프로그램 작성
// select * from student where name = '임유나';
public class FindStudentByName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생의 이름 => ");
        String name = sc.next();

//        String sql = "select * from student where name = ?";
        String sql = "select * from student where name= '"+ name + "'";
        Connection conn = null;
//        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "c##madang",
                    "madang"
            );
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, name);
//            rs = pstmt.executeQuery();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Korean Score: " + rs.getInt("kor"));
                System.out.println("English Score: " + rs.getInt("eng"));
                System.out.println("Math Score: " + rs.getInt("math"));
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
