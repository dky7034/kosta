package com.kosta.exam01;

// 하나의 그래픽에 대한 정보를 표현하기 위한 클래스를 정의합니다.
// 지금은 그래픽이 "선"이기 때문에
// 선의 정보인 시작점 x1, y1과 끝점 x2, y2로 구성되는 클래스를 만들었습니다.
public class GraphicInfo {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // 그래픽 정보(선의 시작점과 끝점)를 초기화하는 생성자
    public GraphicInfo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // 기본 생성자
    public GraphicInfo() {
        // TODO Auto-generated constructor stub
    }

    // 시작점 x1의 getter 메소드
    public int getX1() {
        return x1;
    }

    // 시작점 x1의 setter 메소드
    public void setX1(int x1) {
        this.x1 = x1;
    }

    // 시작점 y1의 getter 메소드
    public int getY1() {
        return y1;
    }

    // 시작점 y1의 setter 메소드
    public void setY1(int y1) {
        this.y1 = y1;
    }

    // 끝점 x2의 getter 메소드
    public int getX2() {
        return x2;
    }

    // 끝점 x2의 setter 메소드
    public void setX2(int x2) {
        this.x2 = x2;
    }

    // 끝점 y2의 getter 메소드
    public int getY2() {
        return y2;
    }

    // 끝점 y2의 setter 메소드
    public void setY2(int y2) {
        this.y2 = y2;
    }
}
