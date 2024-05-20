package com.kosta.exam05;

public class Person {
    protected String name;
    protected String addr;
    protected String phone;

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // 생성자
    public Person() {}
    public Person(String name, String addr, String phone) {
        this.name = name;
        this.addr = addr;
        this.phone = phone;
    }

    // toString override
    @Override
    public String toString() {
        return String.format("이름: %s, 주소: %s, 전화: %s", this.name, this.addr, this.phone);
    }
}
