package com.kosta.exam01;

import java.awt.*; // AWT (Abstract Window Toolkit) 패키지 임포트
import java.awt.event.ActionEvent; // ActionEvent 클래스 임포트
import java.awt.event.ActionListener; // ActionListener 인터페이스 임포트
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection; // Connection 인터페이스 임포트
import java.sql.DriverManager; // DriverManager 클래스 임포트
import java.sql.ResultSet; // ResultSet 인터페이스 임포트
import java.sql.Statement; // Statement 인터페이스 임포트
import java.util.Vector; // Vector 클래스 임포트
import javax.swing.*; // Swing 패키지 임포트

// 학생의 이름, 국어, 영어, 수학 점수를 입력받아 student 테이블에 정보를 추가하는 GUI 프로그램
public class InsertSelectedStudentGUI extends JFrame {
    // JTextField 객체 선언
    JTextField jtf_name;
    JTextField jtf_kor;
    JTextField jtf_eng;
    JTextField jtf_math;

    // JTable 관련 벡터 선언
    Vector<String> colName; // 컬럼명 벡터
    Vector<Vector<String>> rowData; // 데이터 행 벡터
    JTable table; // JTable 객체

    // DB 연결에 사용할 변수 선언
    public static String driver = "oracle.jdbc.driver.OracleDriver"; // JDBC 드라이버
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB URL
    public static String username = "c##madang"; // DB 사용자명
    public static String password = "madang"; // DB 비밀번호

    // DB에서 학생 정보를 조회하여 JTable에 출력하는 메서드
    public void loadStudent() {
        // 벡터를 비워줌
        rowData.clear();
        // DB 연결에 필요한 변수들 초기화
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "select * from student"; // SQL 쿼리
        try {
            Class.forName(driver); // JDBC 드라이버 로드
            conn = DriverManager.getConnection(url, username, password); // DB 연결
            stmt = conn.createStatement(); // Statement 객체 생성
            rs = stmt.executeQuery(sql); // SQL 쿼리 실행
            while (rs.next()) { // 결과 집합 반복
                Vector<String> row = new Vector<>(); // 새로운 행 벡터 생성
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) { // 컬럼 수 만큼 반복
                    row.add(rs.getString(i)); // 각 컬럼 값을 벡터에 추가
                }
                rowData.add(row); // 행 벡터를 데이터 벡터에 추가
            }
            table.updateUI(); // 테이블 UI 업데이트
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage()); // 예외 처리
        } finally {
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
            } catch (Exception exception) {
                System.out.println("예외 발생: " + exception.getMessage()); // 예외 처리
            }
        }
    } // end loadStudent()

    // 생성자 메서드
    public InsertSelectedStudentGUI() {
        // JTextField 객체 초기화
        jtf_name = new JTextField(10);
        jtf_kor = new JTextField(5);
        jtf_eng = new JTextField(5);
        jtf_math = new JTextField(5);

        // JPanel 객체 생성 및 컴포넌트 추가
        JPanel p = new JPanel();
        p.add(new JLabel("이름"));
        p.add(jtf_name);
        p.add(new JLabel("국어"));
        p.add(jtf_kor);
        p.add(new JLabel("영어"));
        p.add(jtf_eng);
        p.add(new JLabel("수학"));
        p.add(jtf_math);

        // JTable 생성
        colName = new Vector<String>();
        colName.add("이름");
        colName.add("국어");
        colName.add("영어");
        colName.add("수학");
        rowData = new Vector<Vector<String>>();
        table = new JTable(rowData, colName);

        // JScrollPane (JTable을 포함하는 JScrollPane 객체 생성)
        JScrollPane jsp = new JScrollPane(table);
        add(p, BorderLayout.NORTH); // JPanel을 프레임 북쪽에 추가
        add(jsp, BorderLayout.CENTER); // JScrollPane을 프레임 중앙에 추가

        // JTable에 마우스 이벤트 연결
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // JTable에서 마우스가 눌렀다가 떼어지면 선택한 행의 인덱스를 가져옴
                int idx = table.getSelectedRow();
                // JTable의 데이터를 가지고 있는 rowData로부터 선택한 행의 정보를 가져옴
                Vector<String> row = rowData.get(idx);
                // 가지고 온 벡터로부터 이름을 가져옴
                String searchName = row.get(0);
                // DB 테이블 student로부터 선택한 학생의 이름에 해당하는
                // 레코드를 조회하기 위한 DB 명령어를 만듦
                String sql = "select * from student where name = '" + searchName + "'";

                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url, username, password);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        String n = rs.getString(1);
                        int kor = rs.getInt(2);
                        int eng = rs.getInt(3);
                        int math = rs.getInt(4);
                        jtf_name.setText(searchName);
                        jtf_kor.setText(kor + "");
                        jtf_eng.setText(eng + "");
                        jtf_math.setText(math + "");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
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
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // JButton 객체 생성 및 추가
        JButton btnAdd = new JButton("등록");
        JButton btnUpdate = new JButton("수정");
        JButton btnDelete = new JButton("삭제");
        // 버튼을 Panel에 추가
        p.add(btnAdd);
        p.add(btnUpdate);
        p.add(btnDelete);
        // 등록(추가) 버튼에 액션 리스너 추가
        btnAdd.addActionListener(new ActionListener() { // 버튼에 액션 리스너 추가

            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                String name = jtf_name.getText(); // 이름 텍스트필드에서 값 가져오기
                int kor = Integer.parseInt(jtf_kor.getText()); // 국어 점수 텍스트필드에서 값 가져오기
                int eng = Integer.parseInt(jtf_eng.getText()); // 영어 점수 텍스트필드에서 값 가져오기
                int math = Integer.parseInt(jtf_math.getText()); // 수학 점수 텍스트필드에서 값 가져오기

                try {
                    // SQL 인서트 쿼리 생성
                    String sql = "insert into student values('" + name + "'," + kor + "," + eng + "," + math + ")";

                    //1. JDBC 드라이버를 메모리로 로드
                    Class.forName(driver);

                    //2. DB 서버 연결
                    conn = DriverManager.getConnection(url, username, password);

                    //3. 데이터베이스 명령어 실행 담당 객체를 생성
                    stmt = conn.createStatement();

                    //4. 데이터베이스 명령어 실행
                    int re = stmt.executeUpdate(sql); // SQL 실행
                    if (re == 1) { // 실행 결과가 성공이면
                        System.out.println("학생의 정보를 추가하였습니다.");
                        loadStudent(); // 학생 정보 로드
                    } else {
                        System.out.println("학생 정보 추가에 실패하였습니다.");
                    }
                } catch (Exception ex) {
                    System.out.println("예외발생:" + ex.getMessage()); // 예외 처리
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close(); // Statement 닫기
                        }
                        if (conn != null) {
                            conn.close(); // Connection 닫기
                        }
                    } catch (Exception ex) {
                        System.out.println("리소스 해제 중 예외발생:" + ex.getMessage()); // 예외 처리
                    }
                }
            }
        });
        // 업데이트 버튼에 액션 리스너 추가 TODO: 업데이트 완성...
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                String searchName = jtf_name.getText();
                try {
                    conn = DriverManager.getConnection(url, username, password);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from student where name = '" + searchName + "'");
                } catch (Exception exception) {
                    System.out.println("예외 발생: " + exception.getMessage());
                }

            }
        });
        // 삭제 버튼에 액션 리스너 추가
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = null; // 데이터베이스와의 연결을 나타내는 Connection 객체를 선언하고 초기화합니다.
                Statement stmt = null; // SQL 문을 실행하는 Statement 객체를 선언하고 초기화합니다.
                ResultSet rs = null; // SQL 쿼리의 결과를 나타내는 ResultSet 객체를 선언하고 초기화합니다.
                String searchName = jtf_name.getText(); // 텍스트 필드에서 입력된 텍스트를 가져와 searchName 변수에 저장합니다.

                try {
                    conn = DriverManager.getConnection(url, username, password);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("delete * from student where name = '" + searchName + "'");
                    if (rs.next()) { //
                        String n = rs.getString(1);
                        if (n == searchName) {

                        }
                    }
                } catch (Exception exception) {
                    System.out.println("예외 발생: " + exception.getMessage());
                }

            }
        });

        loadStudent(); // 초기 학생 정보 로드

        setSize(800, 600); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정

    }

    // main 메서드
    public static void main(String[] args) {
        new InsertSelectedStudentGUI(); // GUI 실행
    }
}
