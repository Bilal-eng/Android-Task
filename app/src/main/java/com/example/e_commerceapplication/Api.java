package com.example.e_commerceapplication;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://private-bd6398-appcent.apiary-mock.com";
    @GET("games")
    Call<ArrayList<ListGames>> getListGames();
}
