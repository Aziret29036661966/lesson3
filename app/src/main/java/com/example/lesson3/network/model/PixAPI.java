package com.example.lesson3.network.model;

import com.example.lesson3.network.model.PixabyModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixAPI {

    @GET("api/?key=28204697-ee2a6e4fc2883e2e8e58c46ee")
    Call < PixabyModel> getImages(
            @Query("q")String qWord
            ,@Query("per_page")int perPage
            ,@Query("page")int page);
}
