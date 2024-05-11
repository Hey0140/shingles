package com.example.shingles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyAPI{

    @POST("/posts/")
    Call<JoinData> post_persons(@Body JoinData person);

    @PATCH("/posts/{pk}/")
    Call<JoinData> patch_persons(@Path("pk") int pk, @Body JoinData person);

    @GET("/posts/")
    Call<List<JoinData>> get_persons();

    @GET("/posts/{pk}/")
    Call<JoinData> get_person_pk(@Path("pk") int pk);
}