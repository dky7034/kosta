package com.kosta.exam06;

abstract class Book {
//    public abstract int getLateFees(int days);
    public int getLateFees(int days) {return 0;}
    public void pro() {}
}
class Novel extends Book {
    @Override
    public int getLateFees(int days) {
        return days * 300;
    }
}
class Poet extends Book {
    @Override
    public int getLateFees(int days) {
        return days * 200;
    }
}
public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Novel();
        Book b2 = new Poet();
        b1.pro(); // Novel 객체에 먼저 접근 -> pro() 없음 -> 부모클래스에서 가져옴
        b2.pro(); // Poet 객체에 먼저 접근 -> pro() 없음 -> 부모클래스에서 가져옴
        b1.getLateFees(2);
        b2.getLateFees(3);
    }
}
