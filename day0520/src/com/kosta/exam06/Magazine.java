package com.kosta.exam06;

public class Magazine extends Book {
    private String releaseDate;

    public String getReleaseDate() {return releaseDate;}
    public void setReleaseDate(String releaseDate) {this.releaseDate = releaseDate;}

    public Magazine() {}
    public Magazine(String title, int page, String author, String releaseDate) {
        super(title, page, author);
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return null;
    }
}
