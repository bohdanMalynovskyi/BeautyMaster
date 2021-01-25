package com.example.beautymaster.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautymaster.R;
import com.example.beautymaster.holder.PortfolioPhotoHolder;
import com.example.beautymaster.models.PortfolioPhoto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PortfolioPhotoAdapter extends RecyclerView.Adapter<PortfolioPhotoHolder> {
    List<PortfolioPhoto> portfolioPhotos;

    public PortfolioPhotoAdapter(List<PortfolioPhoto> portfolioPhotoList) {
        this.portfolioPhotos = portfolioPhotoList;
    }

    @NonNull
    @Override
    public PortfolioPhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_item, parent, false);
        return new PortfolioPhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioPhotoHolder holder, int position) {
        PortfolioPhoto portfolioPhoto = portfolioPhotos.get(position);
        holder.getTvPortfolioPhotoCaption().setText(portfolioPhoto.getCaption());
        Picasso.get()
                .load(portfolioPhoto.getPhotoUrl())
                .placeholder(R.drawable.ic_placeholder)
                .into(holder.getIvPortfolioPhoto());
    }

    @Override
    public int getItemCount() {
        return portfolioPhotos.size();
    }
}
