package com.kosta.exam02;

import java.awt.BorderLayout; // BorderLayout 사용을 위한 클래스
import java.awt.FlowLayout; // FlowLayout 사용을 위한 클래스
import java.awt.event.ActionEvent; // 액션 이벤트 처리를 위한 클래스
import java.awt.event.ActionListener; // 액션 이벤트 리스너 인터페이스
import java.awt.event.MouseEvent; // 마우스 이벤트 처리를 위한 클래스
import java.awt.event.MouseListener; // 마우스 이벤트 리스너 인터페이스
import java.sql.Connection; // 데이터베이스 연결을 위한 클래스
import java.sql.DriverManager; // JDBC 드라이버 로딩을 위한 클래스
import java.sql.ResultSet; // SQL 쿼리 결과를 저장하는 클래스
import java.sql.Statement; // SQL 쿼리를 실행하는 클래스
import java.util.ArrayList; // ArrayList 사용을 위한 클래스
import java.util.Vector; // Vector 사용을 위한 클래스

import javax.swing.JButton; // JButton 사용을 위한 클래스
import javax.swing.JFrame; // JFrame 사용을 위한 클래스
import javax.swing.JLabel; // JLabel 사용을 위한 클래스
import javax.swing.JOptionPane; // JOptionPane 사용을 위한 클래스
import javax.swing.JPanel; // JPanel 사용을 위한 클래스
import javax.swing.JScrollPane; // JScrollPane 사용을 위한 클래스
import javax.swing.JTable; // JTable 사용을 위한 클래스
import javax.swing.JTextField; // JTextField 사용을 위한 클래스

public class StudentTest extends JFrame {
    JTextField jtf_name; // 이름 입력을 위한 텍스트 필드
    JTextField jtf_kor; // 국어 점수 입력을 위한 텍스트 필드
    JTextField jtf_eng; // 영어 점수 입력을 위한 텍스트 필드
    JTextField jtf_math; // 수학 점수 입력을 위한 텍스트 필드

    Vector<String> colNames; // 테이블의 컬럼 이름을 저장할 벡터
    Vector<Vector<String>> rowData; // 테이블의 데이터를 저장할 벡터
    JTable table; // 학생 정보를 표시할 JTable

    // 모든 학생의 목록을 읽어와서 JTable에 출력하는 메소드
    public void loadStudent() {
        rowData.clear(); // 기존 데이터를 제거
        StudentDAO dao = new StudentDAO(); // StudentDAO 객체 생성
        ArrayList<StudentVO> list = dao.listStudent(); // 모든 학생 정보 조회
        for (StudentVO s : list) {
            Vector<String> row = new Vector<String>(); // 학생 한 명의 정보를 저장할 벡터 생성
            row.add(s.getName()); // 이름 추가
            row.add(s.getKor() + ""); // 국어 점수 추가
            row.add(s.getEng() + ""); // 영어 점수 추가
            row.add(s.getMath() + ""); // 수학 점수 추가
            rowData.add(row); // 전체 데이터 벡터에 추가
        }
        table.updateUI(); // 테이블 UI 업데이트
    }

    // 생성자
    public StudentTest() {
        jtf_name = new JTextField(10); // 이름 입력 필드 초기화
        jtf_kor = new JTextField(5); // 국어 점수 입력 필드 초기화
        jtf_eng = new JTextField(5); // 영어 점수 입력 필드 초기화
        jtf_math = new JTextField(5); // 수학 점수 입력 필드 초기화

        JPanel p = new JPanel(); // 패널 생성

        // 패널에 라벨과 텍스트 필드 추가
        p.add(new JLabel("이름"));
        p.add(jtf_name);
        p.add(new JLabel("국어"));
        p.add(jtf_kor);
        p.add(new JLabel("영어"));
        p.add(jtf_eng);
        p.add(new JLabel("수학"));
        p.add(jtf_math);

        // 등록, 수정, 삭제 버튼 생성 및 패널에 추가
        JButton btnAdd = new JButton("등록");
        JButton btnUpdate = new JButton("수정");
        JButton btnDelete = new JButton("삭제");

        p.add(btnAdd);
        p.add(btnUpdate);
        p.add(btnDelete);

        // 테이블 컬럼 이름 벡터 초기화 및 컬럼 이름 추가
        colNames = new Vector<String>();
        colNames.add("이름");
        colNames.add("국어");
        colNames.add("영어");
        colNames.add("수학");
        rowData = new Vector<Vector<String>>(); // 테이블 데이터 벡터 초기화
        table = new JTable(rowData, colNames); // 테이블 생성
        JScrollPane jsp = new JScrollPane(table); // 테이블을 스크롤 패널에 추가

        // 패널과 스크롤 패널을 프레임에 추가
        add(p, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);

        loadStudent(); // 학생 데이터 로드

        // 프레임 설정
        setSize(650, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 테이블에 마우스 리스너 추가
        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                int idx = table.getSelectedRow(); // 선택된 행의 인덱스 얻기
                Vector<String> row = rowData.get(idx); // 선택된 행의 데이터 얻기
                jtf_name.setText(row.get(0)); // 이름 필드에 데이터 설정
                jtf_kor.setText(row.get(1)); // 국어 점수 필드에 데이터 설정
                jtf_eng.setText(row.get(2)); // 영어 점수 필드에 데이터 설정
                jtf_math.setText(row.get(3)); // 수학 점수 필드에 데이터 설정
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

        // 수정 버튼에 액션 리스너 추가
        btnUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 입력된 값을 얻어옴
                String name = jtf_name.getText();
                int kor = Integer.parseInt(jtf_kor.getText());
                int eng = Integer.parseInt(jtf_eng.getText());
                int math = Integer.parseInt(jtf_math.getText());

                StudentVO s = new StudentVO(name, kor, eng, math); // StudentVO 객체 생성

                StudentDAO dao = new StudentDAO(); // StudentDAO 객체 생성
                int re = dao.updateStudent(s); // 학생 정보 수정 메소드 호출
                if (re > 0) {
                    // 수정 성공 시 메시지 출력 및 데이터 재로딩
                    JOptionPane.showMessageDialog(null, "학생의 정보를 수정하였습니다.");
                    loadStudent();
                } else {
                    // 수정 실패 시 메시지 출력
                    JOptionPane.showMessageDialog(null, "학생 정보 수정에 실패하였습니다.");
                }
            }
        });

        // 삭제 버튼에 액션 리스너 추가
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jtf_name.getText();
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "삭제할 학생을 선택하세요.");
                    return;
                }

                int r = JOptionPane.showConfirmDialog(null, "정말로 삭제할까요?", "학생 삭제", JOptionPane.YES_NO_OPTION);
                if (r != 0) {
                    return;
                }

                StudentDAO dao = new StudentDAO();
                int re = dao.deleteStudent(name);
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "학생의 정보를 삭제하였습니다.");
                    loadStudent();
                } else {
                    JOptionPane.showMessageDialog(null, "학생 정보 삭제에 실패하였습니다.");
                }
            }
        });

        // 등록 버튼에 액션 리스너 추가
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 입력된 값을 얻어옴
                String name = jtf_name.getText();
                int kor = Integer.parseInt(jtf_kor.getText());
                int eng = Integer.parseInt(jtf_eng.getText());
                int math = Integer.parseInt(jtf_math.getText());

                StudentVO s = new StudentVO(name, kor, eng, math); // StudentVO 객체 생성
                StudentDAO dao = new StudentDAO(); // StudentDAO 객체 생성
                int re = dao.insertStudent(s); // 학생 정보 추가 메소드 호출
                if (re == 1) {
                    // 추가 성공 시 메시지 출력 및 데이터 재로딩
                    JOptionPane.showMessageDialog(null, "학생의 정보를 추가하였습니다.");
                    loadStudent();
                } else {
                    // 추가 실패 시 메시지 출력
                    JOptionPane.showMessageDialog(null, "학생의 정보 추가에 실패하였습니다.");
                }
            }
        });

    }

    public static void main(String[] args) {
        new StudentTest(); // StudentTest 객체 생성
    }

}
