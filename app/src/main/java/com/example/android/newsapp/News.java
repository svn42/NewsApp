package com.example.android.newsapp;

public class News {
    private String mTitle;
    private String mAuthor;
    private String mCategory;
    private String mDate;
    private String mUrl;

    public News(String category, String author, String title, String date, String url) {
        mCategory = category;
        mAuthor = author;
        mTitle = title;
        mDate = date;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
