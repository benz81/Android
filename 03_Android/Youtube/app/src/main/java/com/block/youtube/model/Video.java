package com.block.youtube.model;

public class Video {
    String title;
    String desc;
    String imgUrl;
    String videoId;

    public Video(){

    }

    public Video(String title, String desc, String imgUrl, String videoId) {
        this.title = title;
        this.desc = desc;
        this.imgUrl = imgUrl;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
