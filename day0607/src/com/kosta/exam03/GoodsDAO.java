package com.kosta.exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {
    // 데이터베이스 드라이버 이름
    public static String driver = "oracle.jdbc.driver.OracleDriver";
    // 데이터베이스 URL
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    // 데이터베이스 사용자 이름
    public static String user = "c##madang";
    // 데이터베이스 비밀번호
    public static String password = "madang";
    // DB 연결을 위한 변수
    Connection conn;
    Statement stmt;
    ResultSet rs;

    /**
     * 모든 상품 목록을 조회하여 ArrayList로 반환하는 메서드
     * @param
     * @return
     */
    public List searchAllGoods () {
        ArrayList<GoodsVO> list = new ArrayList();
        // 모든 물품을 조회하는 SQL 쿼리
        String sql = "select * from goods";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // ResultSet에서 데이터를 읽어와서 ArrayList에 추가
                list.add(new GoodsVO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
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
                System.out.println("예외 발생: " + e.getMessage());
            }
        }
        return list;
    }

    /**
     * 새로운 상품을 등록하기 위한 메서드
     *
     * @param g (GoodsVO 타입)
     * @return re (int 타입)
     */
    public int insertGoods(GoodsVO g) {
        int re = -1; // 결과 값을 저장할 변수 초기화
        // GoodsVO 객체에서 가져오는 값들을 저장하는 변수들
        String item = g.getItem();
        int no = g.getNo();
        int price = g.getPrice();
        int qty = g.getQty();
        // 물품 정보를 삽입하는 SQL 쿼리
        String sql = "insert into goods values(" + g.getNo() + ",'" + g.getItem() + "'," + g.getQty() + "," + g.getPrice() + ")";
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            re = stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
        }
        return re;
    }
}

