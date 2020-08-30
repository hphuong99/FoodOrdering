package com.example.foodordering.retrofit;

import com.example.foodordering.model.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();
}
