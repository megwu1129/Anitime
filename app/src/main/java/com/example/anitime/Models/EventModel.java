package com.example.anitime.Models;

public class EventModel {
    private String day, month, title, location, count, url;

    public EventModel(String day, String month, String title, String location, String count, String url) {
        this.day = day;
        this.month = month;
        this.title = title;
        this.location = location;
        this.count = count;
        this.url = url;
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

    public String getUrl() {
        return url;
    }
}
