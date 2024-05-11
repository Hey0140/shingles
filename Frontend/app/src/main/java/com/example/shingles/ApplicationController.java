package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationController extends Application {
    public final static String TAG = "Backend test";
    private static ApplicationController instance;
    public static ApplicationController getInstance(){return instance;}

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;
    }
    private NetworkService networkService;

    public NetworkService getNetworkService() {
        return networkService;
    }
    public void buildNetworkService(String url){
        synchronized (ApplicationController.class){
            if(networkService == null){
                Log.i(TAG, url);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                networkService = retrofit.create(NetworkService.class);
            }
        }
    }
}