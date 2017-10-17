package com.example.android.speakingnewsapp.Model;

/**
 * Created by anamika on 8/10/17.
 */

public class FoodMode {
    int foodprice;
    String foodname;
    int totalContent;

    public FoodMode(int foodprice, String foodname, int totalContent) {
        this.foodprice = foodprice;
        this.foodname = foodname;
        this.totalContent = totalContent;
    }

    public int getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(int foodprice) {
        this.foodprice = foodprice;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getTotalContent() {
        return totalContent;
    }

    public void setTotalContent(int totalContent) {
        this.totalContent = totalContent;
    }
}
