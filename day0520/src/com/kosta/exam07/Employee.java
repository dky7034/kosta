package com.kosta.exam07;

public class Employee {
    protected String name;  // 이름
    protected String no;    // 사번

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // 월급제 사원과 시간제 사원의 급여 계산 방식이 다르기 때문에
    // 부모클래스를 만드는 시점에서 메서드의 body를 구체화할 수 없어서
    // 메서드의 바디를 비워놓았습니다. (나중에 오버라이드하여 사용)
    // 메서드
    public void computeSalary() {} // 급여 계산 메서드
    
    // 생성자
    public Employee() {}
    public Employee(String name, String no) {
        this.name = name;
        this.no = no;
    }
}
