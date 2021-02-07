package com.dalakoti07.android.restaurantapp.data.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodModel implements Parcelable {
    private String imageUrls;
    private Integer price;
    private Double rating;
    private String name;
    private Integer quantity=1;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public FoodModel(String name, String imageUrls, Integer price, Double rating) {
        this.imageUrls = imageUrls;
        this.name=name;
        this.price = price;
        this.rating = rating;
    }

    protected FoodModel(Parcel in) {
        imageUrls = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readInt();
        }
        if (in.readByte() == 0) {
            rating = null;
        } else {
            rating = in.readDouble();
        }
        name = in.readString();
    }

    public static final Creator<FoodModel> CREATOR = new Creator<FoodModel>() {
        @Override
        public FoodModel createFromParcel(Parcel in) {
            return new FoodModel(in);
        }

        @Override
        public FoodModel[] newArray(int size) {
            return new FoodModel[size];
        }
    };

    public String getImageUrls() {
        return imageUrls;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imageUrls);
        if (price == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(price);
        }
        if (rating == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(rating);
        }
        parcel.writeString(name);
    }
}
