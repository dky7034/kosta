package com.kosta.hw240610.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HWConnectionProvider {
    // connection을 반환하는 메서드
    public static Connection getConnection() {
        String driver = "oracle.jdbc.drvier.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "c##madang";
        String password = "madang";

        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("리소스 해제 중 예외 발생: " + e.getMessage());
        }
        return conn;
    }

    // 매개변수 Connectoin, Statement, ResultSet을 받아서 close 해주는 메서드
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // 매개변수 Connection, Statement를 받아서 close 해주는 메서드
    public static void close(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

