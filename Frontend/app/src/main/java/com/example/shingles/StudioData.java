package com.example.shingles;

import java.io.Serializable;

public class StudioData implements Serializable {
    private boolean heart;
    private String one_discount;
    private String two_discount;
    private String one_account;
    private String two_account;
    private String one_origin;
    private String two_origin;
    private String image_url;

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isHeart() {
        return heart;
    }

    public void setHeart(boolean heart) {
        this.heart = heart;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getOne_discount() {
        return one_discount;
    }

    public String getTwo_discount() {
        return two_discount;
    }

    public String getOne_account() {
        return one_account;
    }

    public String getTwo_account() {
        return two_account;
    }

    public String getOne_origin() {
        return one_origin;
    }

    public String getTwo_origin() {
        return two_origin;
    }

    public void setOne_account(String one_account) {
        this.one_account = one_account;
    }

    public void setOne_discount(String one_discount) {
        this.one_discount = one_discount;
    }

    public void setOne_origin(String one_origin) {
        this.one_origin = one_origin;
    }

    public void setTwo_account(String two_account) {
        this.two_account = two_account;
    }

    public void setTwo_discount(String two_discount) {
        this.two_discount = two_discount;
    }

    public void setTwo_origin(String two_origin) {
        this.two_origin = two_origin;
    }
}
