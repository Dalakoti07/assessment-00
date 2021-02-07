package com.dalakoti07.android.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.dalakoti07.android.restaurantapp.adapters.DishCatAdapter;
import com.dalakoti07.android.restaurantapp.adapters.DishesAdapter;
import com.dalakoti07.android.restaurantapp.data.models.Category;
import com.dalakoti07.android.restaurantapp.data.models.FoodModel;
import com.dalakoti07.android.restaurantapp.data.provider.MockServer;
import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DishCatAdapter.clickListener,DishesAdapter.clickListener{
    private static final String TAG = "MainActivity";
    private RecyclerView rv_cats;
    private RecyclerView rv_top_foods;
    private MockServer mockServer;
    private DishesAdapter dishesAdapter;
    private DishCatAdapter dishCatAdapter;
    private CartItemCounter cartItemCounter;
    private TextView tv_category,tv_top;
    private MaterialButton btn_toggle_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mockServer= MockServer.getMockServerInstance();
        rv_cats=findViewById(R.id.rv_cats);
        rv_top_foods=findViewById(R.id.rv_top_food);
        tv_category=findViewById(R.id.tv_category);
        tv_top=findViewById(R.id.tv_top);
        btn_toggle_language=findViewById(R.id.btn_toggle_language);
        btn_toggle_language.setOnClickListener(view -> {
            Log.d(TAG, "current locale : "+getResources().getConfiguration().locale.toString());
            Locale locale;
            if(getResources().getConfiguration().locale.toString().toLowerCase().contains("en")){
                locale = new Locale("hi");
            }else
                locale= new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            Log.d(TAG, "after the toggle locale : "+getResources().getConfiguration().locale.toString());

            tv_category.setText( getResources().getString(R.string.tv_category));
            tv_top.setText(getResources().getString(R.string.top_food));
        });

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