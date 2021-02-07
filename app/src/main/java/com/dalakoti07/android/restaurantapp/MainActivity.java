package com.dalakoti07.android.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.dalakoti07.android.restaurantapp.adapters.DishCatAdapter;
import com.dalakoti07.android.restaurantapp.adapters.DishesAdapter;
import com.dalakoti07.android.restaurantapp.data.models.Category;
import com.dalakoti07.android.restaurantapp.data.models.FoodModel;
import com.dalakoti07.android.restaurantapp.data.provider.MockServer;

public class MainActivity extends AppCompatActivity implements DishCatAdapter.clickListener,DishesAdapter.clickListener{
    private RecyclerView rv_cats;
    private RecyclerView rv_top_foods;
    private MockServer mockServer;
    private DishesAdapter dishesAdapter;
    private DishCatAdapter dishCatAdapter;
    private CartItemCounter cartItemCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mockServer= MockServer.getMockServerInstance();
        rv_cats=findViewById(R.id.rv_cats);
        rv_top_foods=findViewById(R.id.rv_top_food);

        dishCatAdapter= new DishCatAdapter(this,mockServer.getCategoryArrayList(),this);
        rv_cats.setAdapter(dishCatAdapter);
        cartItemCounter= new CartItemCounter(findViewById(R.id.cart_menu_option));

        findViewById(R.id.cart_menu_option).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,CartActivity.class));
        });
        dishesAdapter= new DishesAdapter(this,mockServer.getTopFoodArrayList(),this,true);
        rv_top_foods.setAdapter(dishesAdapter);
    }

    @Override
    public void cardClicked(Category category) {
        Intent intent= new Intent(this,CategoryDetailActivity.class);
        intent.putParcelableArrayListExtra("arrayList",category.getFoodsList());
        intent.putExtra("category",category.getName());
        startActivity(intent);
    }

    @Override
    public void addToCartClicked(FoodModel foodItem) {
        ((RestaurantApplication)getApplication()).addFoodToList(foodItem);
        cartItemCounter.setCountValue(((RestaurantApplication)getApplication()).getTotalItemsCount());
    }
}