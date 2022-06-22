package com.example.lesson3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import com.example.lesson3.databinding.ActivityMainBinding;
import com.example.lesson3.network.model.Hit;
import com.example.lesson3.network.model.ImageAdapter;
import com.example.lesson3.network.model.PixabyModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    int perPage = 5;
    int page = 1;

    private ActivityMainBinding binding;
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initClickers();
    }

    private void initClickers() {
        binding.swRl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ++page;
                request(binding.edWrote.getText().toString().trim(), perPage, page);
                binding.swRl.setRefreshing(false);
            }
        });
         binding.btnApply.setOnClickListener(v->{
             String keyWord = binding.edWrote.getText().toString().trim();
             request(keyWord, perPage, page);
         });
         binding.btnNew.setOnClickListener(v ->{
             page++;
             request(binding.edWrote.getText().toString().trim(), perPage, page);
         });
    }

    private void request(String word, int perPage, int page){
        App.api.getImages(word, perPage, page).enqueue(new Callback<PixabyModel>() {
            @Override
            public void onResponse(@NonNull Call<PixabyModel> call, @NonNull Response<PixabyModel> response) {
                adapter = new ImageAdapter((ArrayList<Hit>) response.body().getHits());
                binding.rvRc.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PixabyModel> call, Throwable t) {
                Log.e("IWN", "Response" + t.getMessage());
            }
        });
    }
}