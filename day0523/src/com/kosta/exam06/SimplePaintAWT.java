package com.kosta.exam06;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class SimplePaintAWT extends Frame {
    private BufferedImage canvas;
    private Graphics2D g2d;
    private int prevX, prevY;

    public SimplePaintAWT() {
        setTitle("Simple Paint AWT");
        setSize(800, 600);
        setVisible(true);

        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                prevX = e.getX();
                prevY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                g2d.drawLine(prevX, prevY, x, y);
                repaint();

                prevX = x;
                prevY = y;
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(canvas, 0, 0, null);
    }

    public static void main(String[] args) {
        new SimplePaintAWT();
    }
}
