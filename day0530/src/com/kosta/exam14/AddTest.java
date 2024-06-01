package com.kosta.exam14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTest extends JFrame implements ActionListener {

    JTextField jtf01;
    JTextField jtf02;
    JTextField jtf03;

    public AddTest() {
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

        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼이 눌러짐");
        // 눌러진 버튼의 글자를 가져옵니다.
        String cmd = e.getActionCommand();
        System.out.println(cmd);

        // 결과값
        int result;

        // Add를 눌렀을 경우
        if (cmd.equals("Add")) {
            // JText 필드에 입력한 글자를 가져와서(jtf01, jtf02)
            // 정수형으로 형변환 후 계산
            result = Integer.parseInt(jtf01.getText()) + Integer.parseInt(jtf02.getText());
            // 계산한 결과를 필드 3에 입력(jtf03)
            jtf03.setText(String.valueOf(result));
        }
        // Clear를 눌렀을 경우
        else if (cmd.equals("Clear")) {
            // 입력된 값들을 모두 지웁니다.
//            jtf01.setText(null);
//            jtf02.setText(null);
//            jtf03.setText(null);
            jtf01.setText("");
            jtf02.setText("");
            jtf03.setText("");
        }
    }

    public static void main(String[] args) {
        new AddTest();
    }
}
