package com.kosta.hw240610;

public class HWVo {
    private int bookId;
    private String bookName;
    private int price;
    private String publisher;

    // 기본 생성자
    public HWVo() {}

    // getter and setter
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // toString
    @Override
    public String toString() {
        return "HWVo{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
