package com.kosta.exam05;

public class Customer extends Person {
    private int no;
    private int mileage;

    // getter and setter
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    // 생성자
    public Customer(int no, int mileage) {
        this.no = no;
        this.mileage = mileage;
    }

    public Customer() {
        super();
    }

    public Customer(String name, String addr, String phone, int no, int mileage) {
        super(name, addr, phone);
        this.no = no;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
//        String data = "";
//        data += "이름: " + name + ", ";
//        data += "주소: " + addr + ", ";
//        data += "전화: " + phone + ", ";
//        data += "고객번호: " + no + ", ";
//        data += "마일리지: " + mileage;
//        return data;
        return super.toString() + ", " + "고객번호: " + no + ", " + "마일리지: " + mileage;
    }

}
