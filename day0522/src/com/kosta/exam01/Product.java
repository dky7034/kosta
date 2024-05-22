package com.kosta.exam01;

public class Product {
    protected String name;
    protected int price;

    // getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    // 생성자
    public Product() {}
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
