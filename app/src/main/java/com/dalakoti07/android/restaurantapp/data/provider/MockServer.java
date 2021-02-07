package com.dalakoti07.android.restaurantapp.data.provider;

import android.util.Log;

import com.dalakoti07.android.restaurantapp.data.models.Category;
import com.dalakoti07.android.restaurantapp.data.models.FoodModel;

import java.util.ArrayList;

public class MockServer {
    private static final String TAG = "MockServer";

    private static MockServer mockServer;
    private ArrayList<Category> categoryArrayList;
    private ArrayList<FoodModel> topFoodArrayList;

    private MockServer() {
        // private
    }

    public static MockServer getMockServerInstance(){
        if(mockServer!=null){
            return mockServer;
        }else{
            mockServer= new MockServer();
            return mockServer;
        }
    }

    public ArrayList<Category> getCategoryArrayList(){
        if(categoryArrayList==null){
            addTheMockData();
            return categoryArrayList;
        }else
            return categoryArrayList;
    }

    public ArrayList<FoodModel> getTopFoodArrayList(){
        if(topFoodArrayList==null){
            topFoodArrayList=new ArrayList<>();
            topFoodArrayList.add(new FoodModel("Upma","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",80,3.4));
            topFoodArrayList.add(new FoodModel("Veg Noodle","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",150,4.4));
            topFoodArrayList.add(new FoodModel("Veg Noodle","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",150,4.4));

            return topFoodArrayList;
        }else
            return topFoodArrayList;
    }

    private void addTheMockData() {
        categoryArrayList= new ArrayList<>();
        ArrayList<FoodModel> foodModelArrayList= new ArrayList<>();

        // list 1
        foodModelArrayList.add(new FoodModel("Upma","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",80,3.4));
        foodModelArrayList.add(new FoodModel("Dosa","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",150,4.4));
        Category category= new Category("South India","https://res.cloudinary.com/sanitarium/image/fetch/q_auto/https://www.sanitarium.com.au/getmedia%2Fae51f174-984f-4a70-ad3d-3f6b517b6da1%2Ffruits-vegetables-healthy-fats.jpg%3Fwidth%3D1180%26height%3D524%26ext%3D.jpg",foodModelArrayList);
        categoryArrayList.add(category);

        // list 2
        foodModelArrayList.clear();
        foodModelArrayList.add(new FoodModel("Noodles","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",80,3.4));
        foodModelArrayList.add(new FoodModel("Veg Noodle","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",150,4.4));
        category= new Category("Chinese","https://res.cloudinary.com/sanitarium/image/fetch/q_auto/https://www.sanitarium.com.au/getmedia%2Fae51f174-984f-4a70-ad3d-3f6b517b6da1%2Ffruits-vegetables-healthy-fats.jpg%3Fwidth%3D1180%26height%3D524%26ext%3D.jpg",foodModelArrayList);
        categoryArrayList.add(category);

        // list 3
        foodModelArrayList.clear();
        foodModelArrayList.add(new FoodModel("Noodles","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",80,3.4));
        foodModelArrayList.add(new FoodModel("Veg Noodle","https://www.refrigeratedfrozenfood.com/ext/resources/NEW_RD_Website/DefaultImages/default-pasta.jpg?1430942591",150,4.4));
        category= new Category("North Indian","https://res.cloudinary.com/sanitarium/image/fetch/q_auto/https://www.sanitarium.com.au/getmedia%2Fae51f174-984f-4a70-ad3d-3f6b517b6da1%2Ffruits-vegetables-healthy-fats.jpg%3Fwidth%3D1180%26height%3D524%26ext%3D.jpg",foodModelArrayList);
        categoryArrayList.add(category);

    }
}
