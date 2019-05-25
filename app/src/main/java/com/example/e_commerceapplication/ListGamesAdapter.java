package com.example.e_commerceapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListGamesAdapter extends RecyclerView.Adapter<ListGamesAdapter.MyViewHolder> {
    private static final String TAG = "ListGamesAdapter";

    private LayoutInflater inflater;
    private ArrayList<ListGames> dataModelArrayList;
    ArrayList<String> PlatformName;
    ArrayList<String> NumbersOfSales;
    private Context context;


    public ListGamesAdapter(Context context, ArrayList<ListGames> dataModelArrayList) {
        inflater = LayoutInflater.from(context);
        this.dataModelArrayList = dataModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.get().load(dataModelArrayList.get(i).getmImageUrl()).into(myViewHolder.imageView);
        myViewHolder.nameView.setText(dataModelArrayList.get(i).getmName());
        myViewHolder.priceView.setText(dataModelArrayList.get(i).getmPrice());
        if (dataModelArrayList.get(i).getmDiscountPrice() == null) {
            myViewHolder.discountView.setText("0$");
        } else {
            myViewHolder.discountView.setText(dataModelArrayList.get(i).getmDiscountPrice());
        }
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView nameView, priceView, discountView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.image_view);
            nameView = itemView.findViewById(R.id.name_view);
            priceView = itemView.findViewById(R.id.price_view);
            discountView = itemView.findViewById(R.id.discount_price_view);
        }

        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            String platFormName = "";
            String numberOfSales = "";
            int position = viewHolder.getAdapterPosition();
            Intent intent = new Intent(context, ListDetailsActivity.class);
            intent.putExtra("image", dataModelArrayList.get(position).getmImageUrl());
            intent.putExtra("name", dataModelArrayList.get(position).getmName());
            intent.putExtra("release", dataModelArrayList.get(position).getmRelease());
            intent.putExtra("developer", dataModelArrayList.get(position).getmDeveloper());
            intent.putExtra("price", dataModelArrayList.get(position).getmPrice());
            intent.putExtra("discount", dataModelArrayList.get(position).getmDiscountPrice());


            for (int i = 0; i < dataModelArrayList.get(position).getmPlatforms().size(); i++) {
                platFormName += "\n" + dataModelArrayList.get(position).getmPlatforms().get(i).getName();
                numberOfSales += "\n" + dataModelArrayList.get(position).getmPlatforms().get(i).getNumberOfSales();
            }
            Log.d(TAG, "onClick: " + platFormName);
            intent.putExtra("platform", platFormName);
            intent.putExtra("sales", numberOfSales);
            context.startActivity(intent);
        }
    }
}

