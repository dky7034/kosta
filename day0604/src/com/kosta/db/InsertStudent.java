/*
자바에서 데이터베이스에 연결하는 프로그램
<< Java DataBase Connect 프로그램 >>
==> JDBC

<< JDBC 연결 프로그래밍 절차 >>
0. 오라클이 설치된 경로에 JDBC 드라이버가 있어야 합니다.
1. DBMS 드라이버를 메모리에 로드(적재)
2. DB 서버에 연결
3. DB 명령어 실행 담당자 객체를 생성
4. 실행 담당자를 통해서 DB 명령어 실행
5. 사용한 자원을 닫기(close)
*/

package com.kosta.db; // 패키지 선언

import java.sql.Connection; // Connection 클래스 임포트
import java.sql.DriverManager; // DriverManager 클래스 임포트
import java.sql.Statement; // Statement 클래스 임포트

public class InsertStudent { // InsertStudent 클래스 선언
    public static void main(String[] args) { // 메인 메소드 시작
        String sql = "insert into student values('이순신', 80, 90, 100)"; // 실행할 SQL 쿼리 문자열 선언

        Connection conn = null; // Connection 객체를 위한 변수 선언
        Statement stmt = null; // Statement 객체를 위한 변수 선언
        try {

            //1. jdbc 드라이버를 메모리로 로드한다.
            Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버를 로드

            //2. DB 서버에 연결한다.
            String url = "jdbc:oracle:thin:@localhost:1521:XE"; // DB 접속 URL 설정
            String username = "c##madang"; // DB 사용자 이름
            String password = "madang"; // DB 사용자 비밀번호
            conn = DriverManager.getConnection(url, username, password); // DB 서버에 연결

            //3. 데이터베이스 명령어 실행 담당자 객체를 생성한다.
            stmt = conn.createStatement(); // Statement 객체 생성

            //4. 명령어 실행 담당자를 통해서 데이터베이스 명령을 실행한다.
            int re = stmt.executeUpdate(sql); // SQL 쿼리 실행

            if (re == 1) { // 실행 결과가 1이면 성공
                System.out.println("레코드 추가 성공"); // 성공 메시지 출력
            } else { // 그렇지 않으면 실패
                System.out.println("레코드 추가 실패"); // 실패 메시지 출력
            }
        } catch (Exception e) { // 예외 처리 블록 시작
            System.out.println("예외 발생:" + e.getMessage()); // 예외 메시지 출력
        } finally { // finally 블록 시작
            try {
                if (stmt != null) { // stmt가 null이 아니면
                    stmt.close(); // stmt 닫기
                }
                if (conn != null) { // conn이 null이 아니면
                    conn.close(); // conn 닫기
                }
            } catch (Exception e) { // 자원 닫기 시 예외 처리
                System.out.println("예외 발생: " + e.getMessage()); // 예외 메시지 출력
            }
        }
    }
}
