package com.example.beautymaster.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PortfolioPhoto {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String caption;
    private String photoUrl;

    public PortfolioPhoto(String caption, String photoUrl) {
        this.caption = caption;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
