package com.kosta.exam01;

public class DiscountProduct extends Product {
    private double rate;

    // getter and setter
    public double getRate() {return rate;}
    public void setRate(double rate) {this.rate = rate;}

    // 생성자
    public DiscountProduct () {super();}
    public DiscountProduct(String productName, double price, double rate) {}

    @Override
    public int getPrice() {
        // 메서드 override
        // 할인된 가격을 반환하도록 재정의
        return price - (int)(price * rate);
    }

    // toString
    @Override
    public String toString() {
        return "DiscountProduct{" +
                "rate=" + rate +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
