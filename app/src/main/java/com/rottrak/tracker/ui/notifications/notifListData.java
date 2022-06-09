package com.rottrak.tracker.ui.notifications;

public class notifListData {
    String name;
    String date;
    String description;
    int imageUrl;
    boolean isRead;

    notifListData(String name,
                  String date,
                  String description,
                  int imageUrl,
                  boolean isRead){
        this.name = name;
        this.date = date;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isRead = isRead;

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getImageUrl(){
        return imageUrl;
    }

    public boolean isStateRead(){
        return isRead;
    }

    public String getDescription() {
        return description;
    }
}
