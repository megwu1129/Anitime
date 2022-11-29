package com.example.anitime.Models;

import android.widget.ImageView;

public class EventModel {
    private String day, month, title, location, count;
    public int imageView;

    public EventModel(String day, String month, String title, String location, String count, int image) {
        this.day = day;
        this.month = month;
        this.title = title;
        this.location = location;
        this.count = count;
        this.imageView = image;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getCount() {
        return count;
    }

    public int getImageView() {
        return imageView;
    }
}
