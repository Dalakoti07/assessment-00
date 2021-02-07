package com.dalakoti07.android.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.dalakoti07.android.restaurantapp.adapters.DishesAdapter;
import com.dalakoti07.android.restaurantapp.data.models.FoodModel;

import java.util.ArrayList;

public class CategoryDetailActivity extends AppCompatActivity implements DishesAdapter.clickListener{
    RecyclerView rv_food_options;
    DishesAdapter dishesAdapter;
    TextView tv_top;
    private CartItemCounter cartItemCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        tv_top=findViewById(R.id.tv_top);
        rv_food_options=findViewById(R.id.rv_food_options);
        ArrayList<FoodModel> foodModelArrayList= getIntent().getParcelableArrayListExtra("arrayList");
        dishesAdapter= new DishesAdapter(this,foodModelArrayList,this,true);
        rv_food_options.setAdapter(dishesAdapter);
        cartItemCounter= new CartItemCounter(findViewById(R.id.cart_menu_option));
        cartItemCounter.setCountValue(((RestaurantApplication)getApplication()).getTotalItemsCount());
        tv_top.setText("Foods in "+getIntent().getStringExtra("category")+" are: ");
    }

    @Override
    public void addToCartClicked(FoodModel category) {

    }
}