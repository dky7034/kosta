package com.kosta.exam01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCheckBoxTest02 extends JFrame {
    JCheckBox jcb01;
    JCheckBox jcb02;
    JLabel result;

    // 생성자
    public JCheckBoxTest02() {
        setLayout(new FlowLayout());
        jcb01 = new JCheckBox("사과");
        jcb02 = new JCheckBox("포도");
        result = new JLabel();

        add(jcb01);
        add(jcb02);
        add(result);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jcb01.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jcb01.isSelected() && jcb02.isSelected()) {
                    result.setText("사과, 포도를 선택");
                } else if (jcb01.isSelected()) {
                    result.setText("사과 선택");
                } else if (jcb02.isSelected()) {
                    result.setText("포도 선택");
                } else {
                    result.setText("아무것도 선택하지 않음");
                }
            }
        });

        jcb02.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jcb01.isSelected() && jcb02.isSelected()) {
                    System.out.println("사과, 포도 선택");
                } else if (jcb01.isSelected()) {
                    System.out.println("사과 선택");
                } else if (jcb02.isSelected()) {
                    System.out.println("포도 선택");
                } else {
                    System.out.println("아무것도 선택하지 않음");
                }
            }
        });
    }

    public static void main(String[] args) {
        new JCheckBoxTest02();
    }

}
