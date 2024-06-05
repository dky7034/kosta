package com.kosta.exam01;

import javax.swing.*;
import java.util.Vector;

public class JTableTest extends JFrame {
    JTable table;

    public JTableTest() {
        String[] colNames = {"이름", "국어", "영어", "수학"};
        String[][] rowData = {
                {"홍석영", "80", "90", "100"},
                {"임유나", "100", "100", "80"},
                {"유요한", "90", "70", "80"}
        };

        table = new JTable(rowData,colNames);
        JScrollPane jsp = new JScrollPane(table);
        add(jsp);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JTableTest();
    }
}
