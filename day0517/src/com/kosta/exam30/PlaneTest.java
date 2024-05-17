package com.kosta.exam30;

public class PlaneTest {

    public static void main(String[] args) {
        Plane p1 = new Plane();
        Plane p2 = new Plane("에어버스", "A380", 200);

        System.out.println("제작사: " + p2.getCompany());
        System.out.println("기종: " + p2.getModel());
        System.out.println("최대인원: " + p2.getPassenger());


        System.out.println("비행기 대수: " + Plane.getPlanes());



    }
}
