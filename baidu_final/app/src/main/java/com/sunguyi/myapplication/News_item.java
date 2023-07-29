package com.sunguyi.myapplication;

public class News_item {
    private String title;
    private String content;

    private String img_url;

    private String news_url;


    public News_item(String title, String content, String img_url, String news_url) {
        this.title = title;
        this.content = content;
        this.img_url = img_url;
        this.news_url = news_url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getNews_url() {
        return news_url;
    }

}
