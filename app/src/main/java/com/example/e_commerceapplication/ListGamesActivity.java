package com.example.e_commerceapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListGamesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListGamesAdapter listGamesAdapter;
    RelativeLayout emptyView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recycleViewList);
        emptyView = findViewById(R.id.empty_view);

        loadListGames();
    }

    private void loadListGames() {
        //Creating a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                //Here we are using the GsonConverterFactory to directly convert json data to object
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Creating the api interface
        Api api = retrofit.create(Api.class);
        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<ArrayList<ListGames>> call = api.getListGames();

        //then finallly we are making the call using enqueue()
        call.enqueue(new Callback<ArrayList<ListGames>>() {
            @Override
            public void onResponse(Call<ArrayList<ListGames>> call, Response<ArrayList<ListGames>> response) {
                generateGameList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ListGames>> call, Throwable t) {
                emptyView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void generateGameList(ArrayList<ListGames> listGames) {
        recyclerView = findViewById(R.id.recycleViewList);
        listGamesAdapter = new ListGamesAdapter(this, listGames);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListGamesActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listGamesAdapter);
    }
}
