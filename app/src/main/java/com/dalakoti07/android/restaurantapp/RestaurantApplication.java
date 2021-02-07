package com.dalakoti07.android.restaurantapp;

import android.app.Application;

import com.dalakoti07.android.restaurantapp.data.models.FoodModel;

import java.util.ArrayList;

public class RestaurantApplication extends Application {
    private ArrayList<FoodModel> foodModelArrayList= new ArrayList<>();
    private Integer itemsCount=0;

    public Integer getTotalItemsCount(){
        return itemsCount;
    }

    public void addFoodToList(FoodModel foodModel){
        for(FoodModel food:foodModelArrayList){
            if(foodModel==food){
                food.setQuantity(food.getQuantity()+1);
                return;
            }
        }
        foodModelArrayList.add(foodModel);
        itemsCount++;
    }

    public ArrayList<FoodModel> getAllCartItems(){
        return foodModelArrayList;
    }
}
