package com.kosta.exam01;

import com.kosta.db.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GoodsDAO {

    // 상품 정보를 업데이트하는 메서드
    public int updateGoods(GoodsVO g) {
        int re = -1; // 결과 값을 저장할 변수 초기화
        // 업데이트할 SQL 쿼리
        String sql = "update goods set item = '" + g.getItem() + "',qty = " + g.getQty() + ",price = " + g.getPrice() + " where no = " + g.getNo();
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체

        try {
            conn = ConnectionProvider.getConnection(); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            re = stmt.executeUpdate(sql); // SQL 쿼리 실행
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage()); // 예외 발생 시 메시지 출력
        } finally {
            try {
                ConnectionProvider.close(conn, stmt); // 연결 및 Statement 객체 닫기
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage()); // 리소스 해제 중 예외 발생 시 메시지 출력
            }
        }
        return re; // 결과 값 반환
    }

    /**
     * 모든 상품 목록을 조회하여 ArrayList로 반환하는 메서드
     *
     * @return list (ArrayList<GoodsVO> 타입)
     */
    public ArrayList<GoodsVO> searchAllGoods() {
        ArrayList<GoodsVO> list = new ArrayList<>(); // 결과를 저장할 ArrayList 객체 생성
        // 모든 물품을 조회하는 SQL 쿼리
        String sql = "SELECT * FROM goods";
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체
        ResultSet rs = null; // 결과 집합을 저장할 객체

        try {
            conn = ConnectionProvider.getConnection(); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            rs = stmt.executeQuery(sql); // SQL 쿼리 실행

            while (rs.next()) {
                // ResultSet에서 데이터를 읽어와서 ArrayList에 추가
                list.add(new GoodsVO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage()); // 예외 발생 시 메시지 출력
        } finally {
            try {
                ConnectionProvider.close(conn, stmt, rs); // 연결, Statement 객체, ResultSet 객체 닫기
            } catch (Exception e) {
                System.out.println("리소스 해제 중 예외 발생: " + e.getMessage()); // 리소스 해제 중 예외 발생 시 메시지 출력
            }
        }
        return list; // 결과 리스트 반환
    }

    /**
     * 새로운 상품을 등록하기 위한 메서드
     *
     * @param g (GoodsVO 타입)
     * @return re (int 타입)
     */
    public int insertGoods(GoodsVO g) {
        int re = -1; // 결과 값을 저장할 변수 초기화
        // 물품 정보를 삽입하는 SQL 쿼리
        String sql = "INSERT INTO goods VALUES(" + g.getNo() + ",'" + g.getItem() + "'," + g.getQty() + "," + g.getPrice() + ")";
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체

        try {
            conn = ConnectionProvider.getConnection(); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            re = stmt.executeUpdate(sql); // SQL 쿼리 실행
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage()); // 예외 발생 시 메시지 출력
        } finally {
            try {
                ConnectionProvider.close(conn, stmt); // 연결 및 Statement 객체 닫기
            } catch (Exception e) {
                System.out.println("리소스 해제 중 예외 발생: " + e.getMessage()); // 리소스 해제 중 예외 발생 시 메시지 출력
            }
        }
        return re; // 결과 값 반환
    }

    // 상품 번호를 매개변수로 전달받아서 해당 상품을 삭제하는 메서드 정의
    public int deleteGoods(int n) {
        int re = -1; // 결과 값을 저장할 변수 초기화
        // 물품을 삭제하는 SQL 쿼리
        String sql = "delete from goods where no = " + n;
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체

        try {
            conn = ConnectionProvider.getConnection(); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            re = stmt.executeUpdate(sql); // SQL 쿼리 실행
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage()); // 예외 발생 시 메시지 출력
        } finally {
            ConnectionProvider.close(conn, stmt); // 연결 및 Statement 객체 닫기
        }
        return re; // 결과 값 반환
    }
}
