package com.kosta.exam30;

public class Plane {

    private String company;
    private String model;
    private int passenger;
    // 정적 변수 추가
    public static int planes;

    // getter and setter
    public String getCompany() {return company;}
    public String getModel() {return model;};
    public int getPassenger() {return passenger;}
    public void setCompany(String company) {this.company = company;}
    public void setModel(String model) {this.model = model;}
    public void setPassenger(int passenger) {this.passenger = passenger;}
    
    // 생성자
    public Plane() {planes++;}
    public Plane(String company, String model, int passenger) {
        planes++;
        this.company = company;
        this.model = model;
        this.passenger = passenger;
    }
    
    // static 메서드 (int planes)
    public static int getPlanes() {return planes;}
    public void setPlanes(int planes) {this.planes = planes;}
}
