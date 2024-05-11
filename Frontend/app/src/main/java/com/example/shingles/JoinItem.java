package com.example.shingles;

public class JoinItem {
    private String username;
    private String password;
    private String tocken;

    JoinItem(){
        this.username = "";
        this.password = "";
    }

    String getUsername(){
        return username;
    }
    String getPassword(){
        return password;
    }
    String getTocken(){return tocken;}

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }

    void setUsername(String username){
        this.username = username;
    }
    void setPassword(String password){
        this.password = password;
    }

}
