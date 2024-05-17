package com.kosta.exam23;

class Dice {
    private int face;
    public int roll() {
        face = (int)((Math.random() * 6)) + 1;
        return face;
    }

    public int getFace() {
        return face;
    }
}
public class DiceTest {
    public static void main(String[] args) {
        Dice d1 = new Dice();
        Dice d2 = new Dice();

        d1.roll();
        d2.roll();

        System.out.println(d1.roll());
        System.out.println(d2.roll());

    }






}
