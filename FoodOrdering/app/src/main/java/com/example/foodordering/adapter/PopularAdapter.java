package com.example.foodordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodordering.R;
import com.example.foodordering.model.Popular;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private Context context;
    private List<Popular> popularList;

    public PopularAdapter(Context context, List<Popular> popularList) {
        this.context = context;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_item, parent, false);
        return new PopularViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        holder.popularTv.setText(popularList.get(position).getName());

        Glide.with(context).load(popularList.get(position).getImageUrl()).into(holder.popularImg);
    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView popularImg;
        TextView popularTv;


        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularTv = itemView.findViewById(R.id.popular_tv);
            popularImg = itemView.findViewById(R.id.popular_img);

        }
    }


}
