package com.dalakoti07.android.restaurantapp;

import android.view.View;
import android.widget.TextView;

public class CartItemCounter {
    private TextView tv_cart_item_count;
    private int count=0;

    public CartItemCounter(View view){
        tv_cart_item_count= view.findViewById(R.id.tv_cart_count);
    }

    public void setCountValue(Integer countValue){
        count=countValue;
        tv_cart_item_count.setText(count+"");
    }
}
