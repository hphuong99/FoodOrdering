package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foodordering.adapter.PopularAdapter;
import com.example.foodordering.adapter.RecommendedAdapter;
import com.example.foodordering.model.FoodData;
import com.example.foodordering.model.Popular;
import com.example.foodordering.model.Recommended;
import com.example.foodordering.retrofit.ApiInterface;
import com.example.foodordering.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    RecyclerView popularRecyclerView, recommendedRecyclerView;

    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<FoodData>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<FoodData>>() {
            @Override
            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {

                List<FoodData> foodDataList = response.body();
                getPopularData(foodDataList.get(0).getPopular());
                getRecommendedData(foodDataList.get(0).getRecommended());

            }

            @Override
            public void onFailure(Call<List<FoodData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Không phản hồi!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getPopularData(List<Popular> popularList) {
        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }
    private void getRecommendedData(List<Recommended> recommendedList) {
        recommendedRecyclerView = findViewById(R.id.recommended_recyccler);
        recommendedAdapter = new RecommendedAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

}