package com.kosta.exam03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 콤보박스에서 선택한 이미지를 라벨에 출력
public class JComboBoxImageLabelTest extends JFrame {
    // 변수
    JComboBox<String> jcb;
    JLabel jlb;

    // 생성자
    public JComboBoxImageLabelTest() {
        jcb = new JComboBox<String>();
        jcb.addItem("apple");
        jcb.addItem("grape");
        jcb.addItem("banana");
        jcb.addItem("peach");
        jcb.addItem("persimmon");

        jlb = new JLabel();

        add(jcb, BorderLayout.NORTH);
        add(jlb, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String selectedItem = jcb.getSelectedItem().toString();
        System.out.println(selectedItem);

        jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = jcb.getSelectedItem().toString();
                jlb.setText(item);

                updatedLabelImage(item);
            }

            // 라벨에 이미지를 업데이트하는 메서드
            private void updatedLabelImage(String item) {
                String imgPath = "/Users/donggyun/intellij-workspace/day0603/" + item + ".jpg";
                ImageIcon icon = new ImageIcon(imgPath);
                jlb.setIcon(icon);
            }
        });
    }

    public static void main(String[] args) {
        new JComboBoxImageLabelTest();
    }
}
