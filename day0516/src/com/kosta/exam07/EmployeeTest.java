package com.kosta.exam07;

class Employee {
    private String name;
    private String phone;
    private int salary;

    public Employee() {
        name = "임유나";
        phone = "010-1234-5678";
        salary = 5000;
    }

    // getter and setter 메서드
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public int getSalary() {
        return salary;
    }
    public void setName(String n) {
        name = n;
    }
    public void setPhone(String p) {
        phone = p;
    }
    public void setSalary(int s) {
        salary = s;
    }

}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setName("홍길동");
        e1.setPhone("01012345678");
        e1.setSalary(1000);
        System.out.println("이름: " + e1.getName());
        System.out.println("전화번호: " + e1.getPhone());
        System.out.println("연봉: " + e1.getSalary() +"만원");
    }
}
