package com.project.haruman;

public class RequestedItem {
    String title;
    String time;
    String location;
    String pay;


    public RequestedItem(String title, String time, String location, String pay) {
        this.title = title;
        this.time = time;
        this.location = location;
        this.pay = pay;
    }

    public RequestedItem() {}

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPay() {
        return this.pay;
    }

    public void setPay(String day) {
        this.pay = pay;
    }
}