package com.dalakoti07.android.restaurantapp.data.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Category {

    private String name;

    private String banner;

    private ArrayList<FoodModel> foodsList;

    public String getName() {
        return name;
    }

    public String getBanner() {
        return banner;
    }

    public ArrayList<FoodModel> getFoodsList() {
        return foodsList;
    }

    public Category(String name, String banner, ArrayList<FoodModel> foodsList) {
        this.name = name;
        this.banner = banner;
        this.foodsList = foodsList;
    }

    @NonNull
    @Override
    public String toString() {
        return name+" banner : "+banner;
    }
}
