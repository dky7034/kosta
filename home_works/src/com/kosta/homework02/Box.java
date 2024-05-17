package com.kosta.homework02;

public class Box {

    private int height;
    private int width;
    private int length;
    private boolean empty;

    // getter and setter
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public int getLength() {return length;}
    public boolean isEmpty() {return empty;}
    public void setHeigth(int height) {this.height = height;}
    public void setWidth(int width) {this.width = width;}
    public void setLength(int length) {this.length = length;}
    public void setEmpty(boolean empty) {this.empty = empty;}
    
    // 생성자
    public Box() {}
    public Box(int height, int width, int length, boolean empty) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.empty = empty;
    }

}
