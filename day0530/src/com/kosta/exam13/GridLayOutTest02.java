package com.kosta.exam13;

import javax.swing.*;
import java.awt.*;

public class GridLayOutTest02 extends JFrame {
    // 설정한 그리드의 수와 컴포넌트의 수가 맞지 않고
    // 컴포넌트의 수를 행렬에 맞출 수 있으면
    // 컴포넌트의 수에 알아서 맞춰준다.
    public GridLayOutTest02() {
        setLayout(new GridLayout(3,5));
        for (int i = 1; i <= 13; i++) {
            add(new JButton("버튼 " + i));
        }
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GridLayOutTest02();
    }
}
