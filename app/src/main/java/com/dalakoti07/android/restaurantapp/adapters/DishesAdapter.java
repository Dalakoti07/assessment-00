package com.dalakoti07.android.restaurantapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dalakoti07.android.restaurantapp.R;
import com.dalakoti07.android.restaurantapp.data.models.Category;
import com.dalakoti07.android.restaurantapp.data.models.FoodModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.SimpleViewHolder> {
    private Context context;
    private ArrayList<FoodModel> foodArrayList;
    private boolean isDataHidden;

    public interface clickListener{
        void addToCartClicked(FoodModel category);
    }

    public clickListener cardClickListener;

    public DishesAdapter(Context context,ArrayList<FoodModel> foodArrayList,clickListener listener,boolean hideQuant){
        this.context=context;
        this.foodArrayList=foodArrayList;
        this.cardClickListener=listener;
        this.isDataHidden=hideQuant;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimpleViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item_dish,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.bind(foodArrayList.get(position),cardClickListener,isDataHidden);
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_name,tv_price,tv_quant;
        RatingBar ratingBar;
        MaterialButton btn_add;

        void bind(FoodModel food,clickListener listener,boolean hide){
            Glide.with(context)
                    .load(food.getImageUrls())
                    .centerCrop()
                    .into(imageView);
            tv_name.setText(food.getName());
            btn_add.setOnClickListener(view -> {
                listener.addToCartClicked(food);
            });
            ratingBar.setRating(food.getRating().floatValue());
            if(hide){
                tv_quant.setVisibility(View.INVISIBLE);
                tv_price.append(String.valueOf(food.getPrice()));
            }else{
                tv_price.setVisibility(View.VISIBLE);
                tv_quant.setVisibility(View.VISIBLE);
                tv_price.append(String.valueOf(food.getQuantity()*food.getPrice()));
                tv_quant.setText("Quantity: "+food.getQuantity());
            }
        }

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.iv_food_image);
            tv_name= itemView.findViewById(R.id.tv_food_name);
            ratingBar=itemView.findViewById(R.id.tv_food_rating);
            btn_add=itemView.findViewById(R.id.btn_add_cart);
            tv_quant=itemView.findViewById(R.id.tv_quant);
            tv_price=itemView.findViewById(R.id.tv_price);
        }
    }
}
