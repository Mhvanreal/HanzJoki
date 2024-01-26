package com.example.hanzjoki.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hanzjoki.R;

import java.util.ArrayList;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {
    private ArrayList<PromoHome> promoList;

    public PromoAdapter(ArrayList<PromoHome> promoList) {
        this.promoList = promoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_promo, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (promoList == null || promoList.size() <= position || holder.promoName == null) {
            return; // Pengecekan untuk menghindari NullPointerException
        }

        PromoHome promo = promoList.get(position);
        if (promo == null) {
            return; // Pengecekan untuk menghindari NullPointerException
        }

        holder.promoName.setText(promo.getTitle());

        String picUrl = " ";
        switch (position) {
            case 0:
                picUrl = "promoepic";
                holder.promoLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.putih));
                break;
            case 1:
                picUrl = "promolegends";
                holder.promoLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.putih));
                break;
            case 2:
                picUrl = "promomytic";
                holder.promoLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.putih));
                break;
            case 3:
                picUrl = "promohonor";
                holder.promoLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.putih));
                break;
            case 4:
                picUrl = "promoglory";
                holder.promoLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.putih));
                break;
        }

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.promoView);
    }

    @Override
    public int getItemCount() {
        return promoList != null ? promoList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView promoName;
        ImageView promoView;

        ConstraintLayout promoLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            promoName = itemView.findViewById(R.id.promoName);
            promoView = itemView.findViewById(R.id.promoView);
            promoLayout = itemView.findViewById(R.id.promoLayout);
        }
    }
}
