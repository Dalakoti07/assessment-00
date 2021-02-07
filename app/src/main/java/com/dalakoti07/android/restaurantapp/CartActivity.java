package com.dalakoti07.android.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.dalakoti07.android.restaurantapp.adapters.DishesAdapter;
import com.dalakoti07.android.restaurantapp.data.models.FoodModel;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements DishesAdapter.clickListener{
    RecyclerView rv_cart_items;
    DishesAdapter dishesAdapter;
    ArrayList<FoodModel> foodModelArrayList;
    TextView tv_total,tv_gst,tv_grand_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rv_cart_items=findViewById(R.id.rv_cart_items);
        foodModelArrayList= ((RestaurantApplication)getApplication()).getAllCartItems();
        dishesAdapter= new DishesAdapter(this,foodModelArrayList,this,false);
        tv_total=findViewById(R.id.tv_total_val);
        tv_gst=findViewById(R.id.tv_gst_val);
        tv_grand_total=findViewById(R.id.tv_grand_total_val);
        calculateGrandSum();
        rv_cart_items.setAdapter(dishesAdapter);
    }

    private void calculateGrandSum() {
        int count=0;
        for(FoodModel foodModel:foodModelArrayList){
            count+=foodModel.getQuantity()*foodModel.getPrice();
        }
        tv_total.setText(""+count);
        tv_gst.setText(""+(count*.025*2));
        tv_grand_total.setText(""+(1.05*count));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_press_move_in,R.anim.back_press_move_out);
    }

    @Override
    public void addToCartClicked(FoodModel category) {

    }
}