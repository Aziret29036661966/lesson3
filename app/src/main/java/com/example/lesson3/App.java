package com.example.lesson3;

import android.app.Application;

import com.example.lesson3.network.model.PixAPI;
import com.example.lesson3.network.model.RetrofitService;

public class App extends Application {

    public static PixAPI api;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitService retrofitBuilder = new RetrofitService();
        api = retrofitBuilder.getApi();
    }
}
