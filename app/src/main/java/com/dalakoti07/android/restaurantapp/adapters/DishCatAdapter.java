package com.dalakoti07.android.restaurantapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dalakoti07.android.restaurantapp.R;
import com.dalakoti07.android.restaurantapp.data.models.Category;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DishCatAdapter extends RecyclerView.Adapter<DishCatAdapter.SimpleViewHolder> {
    private static final String TAG = "DishCatAdapter";
    private Context context;
    private ArrayList<Category> categoryArrayList;

    public interface clickListener{
        void cardClicked(Category category);
    }

    public clickListener cardClickListener;

    public DishCatAdapter(Context context,ArrayList<Category> categoryArrayList,clickListener listener){
        this.context=context;
        this.categoryArrayList=categoryArrayList;
        this.cardClickListener=listener;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimpleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_category,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.bind(categoryArrayList.get(position),cardClickListener);
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_name;

        void bind(Category category,clickListener listener){
            Log.d(TAG, "binding data image: "+category.getBanner());
            Glide.with(context)
                    .load(category.getBanner())
                    .centerCrop()
                    .into(imageView);
            tv_name.setText(category.getName());
            imageView.setOnClickListener(view -> {
                listener.cardClicked(category);
            });
        }

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.iv_cat_image);
            tv_name= itemView.findViewById(R.id.tv_cat_name);
        }
    }
}
