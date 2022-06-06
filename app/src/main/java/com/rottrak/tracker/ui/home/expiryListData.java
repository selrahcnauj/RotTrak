package com.rottrak.tracker.ui.home;

import java.util.Date;

public class expiryListData {
    String name;
    String date;
    String description;
    String imageUrl;
    String category;

    expiryListData(String name,
                   String date,
                   String description,
                   String imageUrl,
                   String category){
        this.name = name;
        this.date = date;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
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

    public String getCategory(){
        return category;
    }
}
