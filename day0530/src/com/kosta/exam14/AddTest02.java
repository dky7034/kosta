package com.kosta.exam14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTest02 extends JFrame {

    JTextField jtf01;
    JTextField jtf02;
    JTextField jtf03;

    public AddTest02() {
        jtf01 = new JTextField(10);
        jtf02 = new JTextField(10);
        jtf03 = new JTextField(10);

        JPanel p_center = new JPanel();
        JPanel p_south = new JPanel();

        p_center.setLayout(new GridLayout(3, 2));
        p_south.setLayout(new FlowLayout(FlowLayout.CENTER));

        p_center.add(new JLabel("첫 번째 정수: "));
        p_center.add(jtf01);
        p_center.add(new JLabel("두 번째 정수: "));
        p_center.add(jtf02);
        p_center.add(new JLabel("세 번째 정수: "));
        p_center.add(jtf03);

        JButton btnAdd = new JButton("Add");
        JButton btnClear = new JButton("Clear");

        p_south.add(btnAdd);
        p_south.add(btnClear);

        setLayout(new BorderLayout());
        add(p_center, BorderLayout.CENTER);
        add(p_south, BorderLayout.SOUTH);

        setSize(400, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(jtf01.getText());
                int b = Integer.parseInt(jtf02.getText());
                int r = a + b;
                jtf03.setText(String.valueOf(r));
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf01.setText("");
                jtf02.setText("");
                jtf03.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new AddTest02();
    }
}


