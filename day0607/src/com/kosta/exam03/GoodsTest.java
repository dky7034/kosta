package com.kosta.exam03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GoodsTest extends JFrame {
    JTextField jtf_no;
    JTextField jtf_item;
    JTextField jtf_qty;
    JTextField jtf_price;

    Vector<String> colNames;
    Vector<Vector<String>> rowData;
    JTable table;

    public GoodsTest(String title) {
        super(title);

        colNames = new Vector<String>();
        colNames.add("상품번호");
        colNames.add("상품이름");
        colNames.add("상품수량");
        colNames.add("상품가격");

        rowData = new Vector<Vector<String>>();
        table = new JTable(rowData, colNames);
        JScrollPane jsp = new JScrollPane(table);


        jtf_no = new JTextField();
        jtf_item = new JTextField();
        jtf_qty = new JTextField();
        jtf_price = new JTextField();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.setLayout(new GridLayout(4, 2));
        p1.add(new JLabel("상품번호"));
        p1.add(jtf_no);
        p1.add(new JLabel("상품이름"));
        p1.add(jtf_item);
        p1.add(new JLabel("상품수량"));
        p1.add(jtf_qty);
        p1.add(new JLabel("상품가격"));
        p1.add(jtf_price);

        p2.setLayout(new FlowLayout());
        JButton btnAdd = new JButton("등록");
        p2.add(btnAdd);

        JPanel p_north = new JPanel();
        p_north.setLayout(new BorderLayout());
        p_north.add(p1, BorderLayout.CENTER);
        p_north.add(p2, BorderLayout.SOUTH);

        add(p_north, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int no = Integer.parseInt(jtf_no.getText());
                String item = jtf_item.getText();
                int qty = Integer.parseInt(jtf_qty.getText());
                int price = Integer.parseInt(jtf_price.getText());
                GoodsVO g = new GoodsVO(no, item, qty, price);
                GoodsDAO dao = new GoodsDAO();
                int re = dao.insertGoods(g);
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "상품등록에 성공하였습니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "상품등록에 실패하였습니다.");
                }

            }
        });

    }


    public static void main(String[] args) {
        new GoodsTest("상품관리");

    }

}