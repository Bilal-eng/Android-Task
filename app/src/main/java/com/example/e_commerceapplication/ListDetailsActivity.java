package com.example.e_commerceapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListDetailsActivity extends AppCompatActivity {
    private static final String TAG = "ListDetailsActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list);

        //Image of the game
        ImageView imageUrl = findViewById(R.id.image_url_view);
        String image = getIntent().getStringExtra("image");
        Picasso.get().load(image).into(imageUrl);

        //Name of the game
        TextView nameView = findViewById(R.id.name_text_view);
        String name = getIntent().getStringExtra("name");
        nameView.setText("Name: " + name);

        //Release of the game
        TextView releaseName = findViewById(R.id.release_text_view);
        String release = getIntent().getStringExtra("release");
        releaseName.setText("Release: " + release);

        //Developer of game
        TextView developerName = findViewById(R.id.developer_text_view);
        String developer = getIntent().getStringExtra("developer");
        developerName.setText("Developer: " + developer);

        //Price of game
        TextView priceGame = findViewById(R.id.price_text_view);
        String price = getIntent().getStringExtra("price");
        priceGame.setText("Price: " + price);

        //Discount price of game
        TextView discountPrice = findViewById(R.id.discountPrice_text_view);
        String discount = getIntent().getStringExtra("discount");
        if(discount != null) {
            discountPrice.setText("Discount Price: " + discount);
        } else {
            discountPrice.setText("Discount Price: " + "0$");
        }

        //Platform Names
        TextView platformName = findViewById(R.id.platformName_text_view);
        String Plat = getIntent().getStringExtra("platform");
        platformName.setText("Platform Name: " + Plat);

        //Number Of Sales
        TextView noOfSales = findViewById(R.id.platformSales_text_view);
        String sales = getIntent().getStringExtra("sales");
        noOfSales.setText("Number Of Sales: " + sales);

    }
}
