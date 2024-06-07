package com.kosta.exam02;

import java.sql.Connection; // 데이터베이스 연결을 위한 클래스
import java.sql.DriverManager; // JDBC 드라이버 로딩을 위한 클래스
import java.sql.ResultSet; // SQL 쿼리 결과를 저장하는 클래스
import java.sql.Statement; // SQL 쿼리를 실행하는 클래스
import java.util.ArrayList; // ArrayList 사용을 위한 클래스

public class StudentDAO {
    // 데이터베이스 드라이버 이름
    public static String driver = "oracle.jdbc.driver.OracleDriver";
    // 데이터베이스 URL
    public static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    // 데이터베이스 사용자 이름
    public static String username = "c##madang";
    // 데이터베이스 비밀번호
    public static String password = "madang";

    // 학생의 정보를 수정하는 메소드
    public int updateStudent(StudentVO s) {
        int re = -1; // 결과 값을 저장할 변수 초기화
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체
        try {
            // 학생 정보 업데이트 SQL 쿼리
            String sql = "update student set kor=" + s.getKor() + ",eng=" + s.getEng() + ",math=" + s.getMath() + " where name='" + s.getName() + "'";
            Class.forName(driver); // 드라이버 로딩
            conn = DriverManager.getConnection(url, username, password); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            re = stmt.executeUpdate(sql); // SQL 쿼리 실행 후 결과 저장
        } catch (Exception e) {
            // 예외 발생 시 메시지 출력
            System.out.println("예외발생:" + e.getMessage());
        } finally {
            // 리소스 해제
            try {
                if (stmt != null) {
                    stmt.close(); // Statement 객체 해제
                }
                if (conn != null) {
                    conn.close(); // Connection 객체 해제
                }
            } catch (Exception e) {
                // 예외 처리
            }
        }

        return re; // 결과 반환
    }

    // 모든 학생의 정보를 조회하여 ArrayList로 반환하는 메소드
    public ArrayList<StudentVO> listStudent() {
        ArrayList<StudentVO> list = new ArrayList<StudentVO>(); // 학생 정보를 저장할 ArrayList 생성
        String sql = "select * from student"; // 모든 학생 정보를 조회하는 SQL 쿼리
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체
        ResultSet rs = null; // 쿼리 결과를 저장할 ResultSet 객체
        try {
            Class.forName(driver); // 드라이버 로딩
            conn = DriverManager.getConnection(url, username, password); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            rs = stmt.executeQuery(sql); // SQL 쿼리 실행 후 결과 저장
            while (rs.next()) {
                // ResultSet에서 데이터를 읽어와서 ArrayList에 추가
                list.add(new StudentVO(rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
            // 예외 발생 시 메시지 출력
            System.out.println("예외발생:" + e.getMessage());
        } finally {
            // 리소스 해제
            try {
                if (rs != null) {
                    rs.close(); // ResultSet 객체 해제
                }
                if (stmt != null) {
                    stmt.close(); // Statement 객체 해제
                }
                if (conn != null) {
                    conn.close(); // Connection 객체 해제
                }
            } catch (Exception e) {
                // 예외 처리
            }
        }
        return list; // 결과 반환
    }

    // StudentVO를 매개변수로 전달받고 int를 반환하는 insertStudent 라는 이름의 메소드
    public int insertStudent(StudentVO s) {
        int re = -1; // 결과 값을 저장할 변수 초기화
        // 학생 정보를 삽입하는 SQL 쿼리
        String sql = "insert into student values('" + s.getName() + "'," + s.getKor() + "," + s.getEng() + "," + s.getMath() + ")";
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체
        try {
            Class.forName(driver); // 드라이버 로딩
            conn = DriverManager.getConnection(url, username, password); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            re = stmt.executeUpdate(sql); // SQL 쿼리 실행 후 결과 저장
        } catch (Exception e) {
            // 예외 발생 시 메시지 출력
            System.out.println("예외발생:" + e.getMessage());
        } finally {
            // 리소스 해제
            try {
                if (stmt != null) {
                    stmt.close(); // Statement 객체 해제
                }
                if (conn != null) {
                    conn.close(); // Connection 객체 해제
                }
            } catch (Exception e) {
                // 예외 처리
            }
        }

        return re; // 결과 반환
    }

    // 학생의 이름을 매개변수로 전달받아 삭제하는 메서드
    public int deleteStudent(String name) {
        int re = -1; // 결과값을 저장할 변수 초기화
        // 학생 정보를 삭제하는 SQL 쿼리
        String sql = "delete from student where name='" + name + "'";
        Connection conn = null; // 데이터베이스 연결 객체
        Statement stmt = null; // SQL 쿼리 실행 객체
        try {
            Class.forName(driver); // 드라이버 로딩
            conn = DriverManager.getConnection(url, username, password); // 데이터베이스 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            re = stmt.executeUpdate(sql); // SQL 쿼리 실행 후 결과 저장
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            // 리소스 해제
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

        return re; // 결과 반환
    }

}
