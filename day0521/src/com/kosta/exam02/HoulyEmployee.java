package com.kosta.exam02;

public abstract class HoulyEmployee extends Employee {
    private int base;	//시간당 임금
    private int hours;	//일한 시간
    private int salary;	//실수령액


    @Override
    public void computeSalary() {
        salary = base * hours;
    }

//    public HourlyEmployee() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//    public HourlyEmployee(String name, String no, int base, int hours) {
//        super(name, no);
//        this.base = base;
//        this.hours = hours;
//    }
    @Override
    public String toString() {
        return "HourlyEmployee [base=" + base + ", hours=" + hours + ", salary=" + salary + ", name=" + name + ", no="
                + no + "]";
    }
    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

}
