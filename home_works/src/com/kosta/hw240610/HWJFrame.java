package com.kosta.hw240610;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class HWJFrame extends JFrame {
    JPanel panel;
    JTextField textField;
    JButton btnAdd;
    JButton btnUpdate;
    JButton btnDelete;
    JButton btnSearch;
    JLabel label;
    JOptionPane optionPane;
    JTable table;
    JScrollPane scrollPane;
    JTextField jtf1;
    JTextField jtf2;
    JTextField jtf3;
    JTextField jtf4;
    Vector<String> colNames;
    Vector<Vector<String>> rowData;

    // 생성자
    public HWJFrame(String title) {
        super(title);

        colNames = new Vector<String>();
        colNames.add("도서번호");
        colNames.add("도서명");
        colNames.add("가격");
        colNames.add("출판사");

        rowData = new Vector<Vector<String>>();
        table = new JTable();
        scrollPane = new JScrollPane(table);

        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField();
        jtf4 = new JTextField();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.setLayout(new GridLayout(4, 2));
        p1.add(new JLabel("도서번호"));
        p1.add(jtf1);
        p1.add(new JLabel("도서명"));
        p1.add(jtf2);
        p1.add(new JLabel("가격"));
        p1.add(jtf3);
        p1.add(new JLabel("출판사"));
        p1.add(jtf4);

        p2.setLayout(new FlowLayout());
        btnAdd = new JButton("등록");
        btnSearch = new JButton("조회");
        btnUpdate = new JButton("수정");
        btnDelete = new JButton("삭제");
        p2.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        p2.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        p2.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        p2.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                int idx = table.getSelectedRow(); // 선택된 행 인덱스 가져오기
                Vector<String> row = rowData.get(idx); // 선택한 행 데이터 가져오기
                jtf1.setText(row.get(0)); // 도서번호 텍스트 필드 설정
                jtf2.setText(row.get(1)); // 도서명 텍스트 필드 설정
                jtf3.setText(row.get(2)); // 가격 텍스트 필드 설정
                jtf4.setText(row.get(3)); // 출판사 텍스트 필드 설정
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        new HWJFrame("HW 240610");
    }

}
