package com.kosta.exam07;

public class HourlyEmployee extends Employee {
    private int hourlyRate; // 시간당 임금
    private int workHour;   // 일한 시간
    private int pay;        // 실수령액

    // getter and setter
    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }
    
    // 생성자
    public HourlyEmployee(int hourlyRate, int workHour, int pay) {
        this.hourlyRate = hourlyRate;
        this.workHour = workHour;
        this.pay = pay;
    }
    public HourlyEmployee(String name, String no, int hourlyRate, int workHour, int pay) {
        super(name, no);
        this.hourlyRate = hourlyRate;
        this.workHour = workHour;
        this.pay = pay;
    }
    // 기본생성자
    public HourlyEmployee() {
        super();
    }
    public HourlyEmployee(String name, String no, int hourlyRate, int workHour) {
        super(name, no);
        this.hourlyRate = hourlyRate;
        this.workHour = workHour;
    }

    // toString Override
    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hourlyRate=" + hourlyRate +
                ", workHour=" + workHour +
                ", pay=" + pay +
                '}';
    }

    // 메서드 오버라이딩
    @Override
    public void computeSalary() {
//        super.computeSalary();

    }
}
