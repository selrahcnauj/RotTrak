package com.rottrak.tracker.ui.home;

import java.util.Date;

public class expiryListData {
    String name;
    int quantity;
    String date;
    String description;
    int imageUrl;
    String category;

    expiryListData(String name,
                   int quantity,
                   String date,
                   String description,
                   int imageUrl,
                   String category){
        this.name = name;
        this.quantity = quantity;
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

    public String getDescription() {return description;}

    public int getQuantity() { return quantity; }

    public int getImageUrl(){
        return imageUrl;
    }

    public String getCategory(){
        return category;
    }
}
