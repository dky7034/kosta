package com.kosta.exam01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class InsertSelectStudentGUI extends JFrame {
    JTextField jtf_name;
    JTextField jtf_kor;
    JTextField jtf_eng;
    JTextField jtf_math;

    Vector<String> colNames;
    Vector<Vector<String>> rowData;
    JTable table;

    public static String driver = "oracle.jdbc.driver.OracleDriver";
    public static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static String username = "c##madang";
    public static String password = "madang";

    // 데이터베이스 student의 모든 학생의 정보를 조회하여
    // JTable에 출력하는 메소드
    public void loadStudent() {

        //벡터를 깨끗이 비워준다.
        rowData.clear();

        String sql = "select * from student";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(1);
                int kor = rs.getInt(2);
                int eng = rs.getInt(3);
                int math = rs.getInt(4);
                Vector<String> row = new Vector<String>();
                row.add(name);
                row.add(kor + "");
                row.add(eng + "");
                row.add(math + "");
                rowData.add(row);
            }
            table.updateUI();

        } catch (Exception e) {
            System.out.println("예외발생:" + e.getMessage());
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
                // TODO: handle exception
            }
        }
    }


    public InsertSelectStudentGUI() {

        jtf_name = new JTextField(10);
        jtf_kor = new JTextField(5);
        jtf_eng = new JTextField(5);
        jtf_math = new JTextField(5);

        JPanel p = new JPanel();

        p.add(new JLabel("이름"));
        p.add(jtf_name);
        p.add(new JLabel("국어"));
        p.add(jtf_kor);
        p.add(new JLabel("영어"));
        p.add(jtf_eng);
        p.add(new JLabel("수학"));
        p.add(jtf_math);

        JButton btnAdd = new JButton("등록");
        JButton btnUpdate = new JButton("수정");
        JButton btnDelete = new JButton("삭제");

        p.add(btnAdd);
        p.add(btnUpdate);
        p.add(btnDelete);

        colNames = new Vector<String>();
        colNames.add("이름");
        colNames.add("국어");
        colNames.add("영어");
        colNames.add("수학");
        rowData = new Vector<Vector<String>>();
        table = new JTable(rowData, colNames);
        JScrollPane jsp = new JScrollPane(table);

        add(p, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);

        //JTable에 마우스 이벤트 연결
        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // JTable에서 마우스를 눌렀다가 떼어지면 선택한 행의 인덱스를 갖고 온다.
                int idx = table.getSelectedRow();

                // JTable의 데이터를 갖고있는 rowData로 부터 선택한 행의 정보를 갖고 온다.
                Vector<String> row = rowData.get(idx);

                // 갖고온 벡터로 부터 이름을 뽑아 온다.
                String search = row.get(0);

                // 데이터베이스 테이블 student로 부터 선택한 학생의 이름에 해당하는
                // 레코드를 조회하기 위한 데이터베이스 명령어를 만든다.
                String sql = "select * from student where name = '" + search + "'";
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url, username, password);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                    ;
                    if (rs.next()) {
                        String name = rs.getString(1);
                        int kor = rs.getInt(2);
                        int eng = rs.getInt(3);
                        int math = rs.getInt(4);
                        jtf_name.setText(name);
                        jtf_kor.setText(kor + "");
                        jtf_eng.setText(eng + "");
                        jtf_math.setText(math + "");
                    }
                } catch (Exception ex) {
                    // TODO: handle exception
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
                    } catch (Exception ex) {
                        // TODO: handle exception
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                String name = jtf_name.getText();
                int kor = Integer.parseInt(jtf_kor.getText());
                int eng = Integer.parseInt(jtf_eng.getText());
                int math = Integer.parseInt(jtf_math.getText());

                try {
                    String sql = "insert into student values('" + name + "'," + kor + "," + eng + "," + math + ")";

                    //1. jdbc드라이버를 메모리로 로드한다.
                    Class.forName(driver);

                    //2. DB서버에 연결한다.
                    conn = DriverManager.getConnection(
                            url,
                            username,
                            password);

                    //3. 데이터베이스 명령어 실행 담당 객체를 생성
                    stmt = conn.createStatement();

                    //4. 데이터베이스 명령어를 실행한다.
                    int re = stmt.executeUpdate(sql);

                    if (re == 1) {
                        System.out.println("학생의 정보를 추가 하였습니다.");
                        loadStudent();
                    } else {
                        System.out.println("학생의 정보 추가에 실패하였습니다.");
                    }

                } catch (Exception ex) {
                    System.out.println("예외발생:" + ex.getMessage());
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (Exception ex) {
                        // TODO: handle exception
                    }
                }
            }
        });

        loadStudent();

        setSize(650, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new InsertSelectStudentGUI();
    }

}

