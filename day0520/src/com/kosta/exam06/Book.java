package com.kosta.exam06;

public class Book {
    protected String title;
    protected int page;
    protected String author;

    public String getTitle() {return title;}
    public int getPage() {return page;}
    public String getAuthor() {return author;}
    public void setTitle(String title) {this.title = title;}
    public void setPage(int page) {this.page = page;}
    public void setAuthor(String author) {this.author = author;}

    public Book() {}
    public Book(String title, int page, String author) {
        this.title = title;
        this.page = page;
        this.author = author;
    }

    @Override
    public String toString() {
        return null;
    }
}
