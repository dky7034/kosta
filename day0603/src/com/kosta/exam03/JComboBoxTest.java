package com.kosta.exam03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxTest extends JFrame {
    JComboBox<String> jcb;
    JLabel jlb;

    // 생성자
    public JComboBoxTest() {
        jcb = new JComboBox<String>();
        jcb.addItem("사과");
        jcb.addItem("포도");
        jcb.addItem("수박");
        jcb.addItem("딸기");
        jcb.addItem("오렌지");

        jlb = new JLabel();

        add(jcb, BorderLayout.NORTH);
        add(jlb, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jcb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String item = jcb.getSelectedItem().toString();
                jlb.setText(item + "을(를) 선택하였습니다.");
            }
        });
    }

    public static void main(String[] args) {
        new JComboBoxTest();
    }
}
