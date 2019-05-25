package com.example.e_commerceapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.internal.platform.Platform;

public class ListGames {

    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("release")
    @Expose
    private String mRelease;
    @SerializedName("developer")
    @Expose
    private String mDeveloper;
    @SerializedName("imageUrl")
    @Expose
    private String mImageUrl;
    @SerializedName("price")
    @Expose
    private String mPrice;
    @SerializedName("discountPrice")
    @Expose
    private String mDiscountPrice;
    @SerializedName("Platforms")
    @Expose
    private ArrayList<Platforms> mPlatforms ;


    public String getmName() {
        return mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmRelease(String mRelease) {
        this.mRelease = mRelease;
    }

    public void setmDeveloper(String mDeveloper) {
        this.mDeveloper = mDeveloper;
    }

    public String getmDiscountPrice() {
        return mDiscountPrice;
    }

    public String getmRelease() {
        return mRelease;
    }

    public String getmDeveloper() {
        return mDeveloper;
    }

    public void setmPlatforms(ArrayList<Platforms> mPlatforms) {
        this.mPlatforms = mPlatforms;
    }

    public ArrayList<Platforms> getmPlatforms() {
        return mPlatforms;
    }
}