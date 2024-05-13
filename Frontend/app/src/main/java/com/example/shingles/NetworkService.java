package com.example.shingles;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NetworkService {

    @Headers("Content-type: application/json")
    @POST("/users/register/")
    Call<JoinItem> post_persons(@Body JoinItem person);
    @Headers("Content-type: application/json")
    @POST("/users/login/")
    Call<PersonItem> login_persons(@Body JoinItem person);

    @PATCH("/posts/{pk}/")
    Call<JoinItem> patch_persons(@Path("pk") int pk, @Body JoinItem person);

//    @GET("/users/login/")
//    Call<PersonItem> get_login_persons(@Body JoinItem person);

    @GET("/posts/{pk}/")
    Call<JoinItem> get_person_pk(@Path("pk") int pk);
}