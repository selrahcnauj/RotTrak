package com.rottrak.tracker.ui.notifications;

public class notifListData {
    String name;
    String date;
    String description;
    String imageUrl;
    boolean isRead;

    notifListData(String name,
                  String date,
                  String description,
                  String imageUrl){
        this.name = name;
        this.date = date;
        this.description = description;
        this.imageUrl = imageUrl;

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public boolean isStateRead(){
        return isRead;
    }

    public String getDescription() {
        return description;
    }
}
