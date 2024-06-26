package com.kosta.exam05;

public class GraphicInfo {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int drawType;
    private int drawColor;

    public GraphicInfo(int x1, int y1, int x2, int y2, int drawType, int drawColor) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.drawType = drawType;
        this.drawColor = drawColor;
    }

    public GraphicInfo() {
        super();
    }

    public int getDrawColor() {
        return drawColor;
    }
    public void setDrawColor(int drawColor) {
        this.drawColor = drawColor;
    }
    public int getDrawType() {
        return drawType;
    }
    public void setDrawType(int drawType) {
        this.drawType = drawType;
    }
    public int getX1() {
        return x1;
    }
    public void setX1(int x1) {
        this.x1 = x1;
    }
    public int getY1() {
        return y1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public int getX2() {
        return x2;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public int getY2() {
        return y2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }

}