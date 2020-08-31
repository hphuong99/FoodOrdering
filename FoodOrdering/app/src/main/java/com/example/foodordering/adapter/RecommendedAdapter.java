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
import com.example.foodordering.model.Recommended;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> {

    private Context context;

    private List<Recommended> recommendedList;

    public RecommendedAdapter(Context context, List<Recommended> recommendedList) {
        this.context = context;
        this.recommendedList = recommendedList;
    }

    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_item, parent, false);
        return new RecommendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.RecommendedViewHolder holder, int position) {
        holder.recoommendedName.setText(recommendedList.get(position).getName());
        holder.recoommendedRating.setText(recommendedList.get(position).getRating());
        holder.recoommendedDeliveryTime.setText(recommendedList.get(position).getDeliveryTime());
        holder.recoommendedCharges.setText(recommendedList.get(position).getDeliveryCharges());

        Glide.with(context).load(recommendedList.get(position).getImageUrl()).into(holder.recommendedImage);

    }

    @Override
    public int getItemCount() {
        return recommendedList.size();
    }

    public static class RecommendedViewHolder extends RecyclerView.ViewHolder {

        ImageView recommendedImage;
        TextView recoommendedName, recoommendedRating, recoommendedDeliveryTime, recoommendedCharges;

        public RecommendedViewHolder(@NonNull View itemView) {
            super(itemView);

            recommendedImage = itemView.findViewById(R.id.recoommended_image);
            recoommendedName = itemView.findViewById(R.id.recommended_name);
            recoommendedRating = itemView.findViewById(R.id.recommended_rating);
            recoommendedDeliveryTime = itemView.findViewById(R.id.recommended_delivery_time);
            recoommendedCharges = itemView.findViewById(R.id.delivery_type);

        }
    }


}
