package com.block.movieapp.model;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int attendance;
    private String year;
    private int reply_cnt;
    private Double avg_rating;

    public Movie(int id, String title, String genre, int attendance, String year, int reply_cnt, Double avg_rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.attendance = attendance;
        this.year = year;
        this.reply_cnt = reply_cnt;
        this.avg_rating = avg_rating;
    }
    public Movie(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getReply_cnt() {
        return reply_cnt;
    }

    public void setReply_cnt(int reply_cnt) {
        this.reply_cnt = reply_cnt;
    }

    public Double getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(Double avg_rating) {
        this.avg_rating = avg_rating;
    }
}
