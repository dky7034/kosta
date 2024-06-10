package com.kosta.exam01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class GoodsTest extends JFrame {
    JTextField jtf_no; // 상품 번호 입력 필드
    JTextField jtf_item; // 상품 이름 입력 필드
    JTextField jtf_qty; // 상품 수량 입력 필드
    JTextField jtf_price; // 상품 가격 입력 필드

    Vector<String> colNames; // 테이블 컬럼 이름
    Vector<Vector<String>> rowData; // 테이블 데이터
    JTable table; // 상품 목록을 표시할 테이블

    int no; // 상품 번호
    String item; // 상품 이름
    int qty; // 상품 수량
    int price; // 상품 가격

    /**
     * 텍스트 필드의 입력값을 읽어와서 각각의 변수에 저장하는 메서드
     */
    public void setData() {
        no = Integer.parseInt(jtf_no.getText()); // 텍스트 필드에서 상품 번호를 읽어와서 변수에 저장
        item = jtf_item.getText(); // 텍스트 필드에서 상품 이름을 읽어와서 변수에 저장
        qty = Integer.parseInt(jtf_qty.getText()); // 텍스트 필드에서 상품 수량을 읽어와서 변수에 저장
        price = Integer.parseInt(jtf_price.getText()); // 텍스트 필드에서 상품 가격을 읽어와서 변수에 저장
    }

    /**
     * 모든 상품목록을 읽어와서 JTable에 출력하는 메서드
     */
    public void loadGoods() {
        rowData.clear(); // 기존 데이터를 삭제
        GoodsDAO dao = new GoodsDAO(); // 데이터베이스 접근 객체 생성
        ArrayList<GoodsVO> list = dao.searchAllGoods(); // 모든 상품 목록 조회
        for (GoodsVO g : list) { // 조회한 상품 목록을 테이블 데이터에 추가
            Vector<String> row = new Vector<String>();
            row.add(g.getNo() + "");
            row.add(g.getItem());
            row.add(g.getQty() + "");
            row.add(g.getPrice() + "");
            rowData.add(row);
        }
        table.updateUI(); // 테이블 업데이트
    }

    public GoodsTest(String title) {
        super(title); // JFrame 제목 설정

        colNames = new Vector<String>(); // 테이블 컬럼 이름 설정
        colNames.add("상품번호");
        colNames.add("상품이름");
        colNames.add("상품수량");
        colNames.add("상품가격");

        rowData = new Vector<Vector<String>>(); // 테이블 데이터 초기화
        table = new JTable(rowData, colNames); // JTable 생성
        JScrollPane jsp = new JScrollPane(table); // JTable을 포함하는 JScrollPane 생성

        jtf_no = new JTextField(); // 상품 번호 입력 필드 생성
        jtf_item = new JTextField(); // 상품 이름 입력 필드 생성
        jtf_qty = new JTextField(); // 상품 수량 입력 필드 생성
        jtf_price = new JTextField(); // 상품 가격 입력 필드 생성
        JPanel p1 = new JPanel(); // 입력 필드와 레이블을 포함하는 패널 생성
        JPanel p2 = new JPanel(); // 버튼을 포함하는 패널 생성

        p1.setLayout(new GridLayout(4, 2)); // 4x2 그리드 레이아웃 설정
        p1.add(new JLabel("상품번호")); // 상품 번호 레이블 추가
        p1.add(jtf_no); // 상품 번호 입력 필드 추가
        p1.add(new JLabel("상품이름")); // 상품 이름 레이블 추가
        p1.add(jtf_item); // 상품 이름 입력 필드 추가
        p1.add(new JLabel("상품수량")); // 상품 수량 레이블 추가
        p1.add(jtf_qty); // 상품 수량 입력 필드 추가
        p1.add(new JLabel("상품가격")); // 상품 가격 레이블 추가
        p1.add(jtf_price); // 상품 가격 입력 필드 추가

        p2.setLayout(new FlowLayout()); // FlowLayout 설정
        JButton btnAdd = new JButton("등록"); // 등록 버튼 생성
        JButton btnUpdate = new JButton("수정"); // 수정 버튼 생성
        JButton btnDelete = new JButton("삭제"); // 삭제 버튼 생성
        p2.add(btnAdd); // 등록 버튼 추가
        p2.add(btnUpdate); // 수정 버튼 추가
        p2.add(btnDelete); // 삭제 버튼 추가

        JPanel p_north = new JPanel(); // 상단 패널 생성
        p_north.setLayout(new BorderLayout()); // BorderLayout 설정
        p_north.add(p1, BorderLayout.CENTER); // 입력 필드 패널을 중앙에 추가
        p_north.add(p2, BorderLayout.SOUTH); // 버튼 패널을 남쪽에 추가

        add(p_north, BorderLayout.NORTH); // 상단 패널을 프레임에 추가
        add(jsp, BorderLayout.CENTER); // JScrollPane을 프레임에 추가

        loadGoods(); // 상품 목록 로드
        setSize(400, 300); // 프레임 크기 설정
        setVisible(true); // 프레임을 보이도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램 종료 설정

        // 수정 버튼 클릭 시 동작 설정
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setData(); // 텍스트 필드의 입력값을 변수에 저장
                GoodsVO g = new GoodsVO(no, item, qty, price); // GoodsVO 객체 생성
                GoodsDAO dao = new GoodsDAO(); // GoodsDAO 객체 생성
                int re = dao.updateGoods(g); // 상품 정보 수정
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "상품의 정보를 수정하였습니다."); // 수정 성공 메시지
                    loadGoods(); // 테이블 업데이트
                } else {
                    JOptionPane.showMessageDialog(null, "상품 정보 수정에 실패하였습니다."); // 수정 실패 메시지
                }
            }
        });

        // 삭제 버튼 클릭 시 동작 설정
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setData(); // 텍스트 필드의 입력값을 변수에 저장
                GoodsDAO dao = new GoodsDAO(); // GoodsDAO 객체 생성
                int re = dao.deleteGoods(no); // 상품 삭제
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "상품 삭제를 완료하였습니다."); // 삭제 성공 메시지
                    loadGoods(); // 테이블 업데이트
                } else {
                    JOptionPane.showMessageDialog(null, "상품 삭제를 실패하였습니다."); // 삭제 실패 메시지
                }
            }
        });

        // 테이블 행 클릭 시 텍스트 필드에 데이터 설정
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int idx = table.getSelectedRow(); // 선택한 행 인덱스 가져오기
                Vector<String> row = rowData.get(idx); // 선택한 행 데이터 가져오기
                jtf_no.setText(row.get(0)); // 상품 번호 텍스트 필드 설정
                jtf_item.setText(row.get(1)); // 상품 이름 텍스트 필드 설정
                jtf_qty.setText(row.get(2)); // 상품 수량 텍스트 필드 설정
                jtf_price.setText(row.get(3)); // 상품 가격 텍스트 필드 설정
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 등록 버튼 클릭 시 동작 설정
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setData(); // 텍스트 필드의 입력값을 변수에 저장
                    GoodsVO g = new GoodsVO(no, item, qty, price); // GoodsVO 객체 생성
                    GoodsDAO dao = new GoodsDAO(); // GoodsDAO 객체 생성
                    int re = dao.insertGoods(g); // 상품 등록
                    if (re > 0) {
                        JOptionPane.showMessageDialog(null, "상품등록에 성공하였습니다."); // 등록 성공 메시지
                        loadGoods();  // 테이블 업데이트
                        jtf_no.setText("");  // 입력 필드 초기화
                        jtf_item.setText("");
                        jtf_qty.setText("");
                        jtf_price.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "상품등록에 실패하였습니다."); // 등록 실패 메시지
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "올바른 숫자를 입력하세요."); // 입력 오류 메시지
                }

            }
        });

    }

    public static void main(String[] args) {
        new GoodsTest("상품관리"); // 프로그램 실행
    }

}
