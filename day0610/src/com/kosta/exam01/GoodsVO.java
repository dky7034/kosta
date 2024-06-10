package com.kosta.exam01;

public class GoodsVO {
    private int no;
    private String item;
    private int qty;
    private int price;

    // 모든 필드를 초기화하는 생성자
    public GoodsVO(int no, String item, int qty, int price) {
        this.no = no;
        this.item = item;
        this.qty = qty;
        this.price = price;
    }

    // getter and setter
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 객체 정보를 문자열로 반환하는 메서드
    @Override
    public String toString() {
        return "GoodsVO{" +
                "no=" + no +
                ", item='" + item + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
