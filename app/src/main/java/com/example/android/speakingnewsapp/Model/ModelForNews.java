package com.example.android.speakingnewsapp.Model;

/**
 * Created by anamika on 30/8/17.
 */

public class ModelForNews {

    private String headline;
    int image;

    public ModelForNews(String headlineC, int imageC) {
        headline = headlineC;
        image = imageC;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
