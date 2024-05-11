package com.example.shingles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JoinData {
    private String username;
    private String password;

    JoinData(){
        this.username = "";
        this.password = "";
    }

    String getUsername(){
        return username;
    }
    String getPassword(){
        return password;
    }
    void setUsername(String username){
        this.username = username;
    }
    void setPassword(String password){
        this.password = password;
    }

}
