package com.example.beautymaster.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.beautymaster.R;

public class PortfolioPhotoHolder extends RecyclerView.ViewHolder {
    private final TextView tvPortfolioPhotoCaption;
    private final ImageView ivPortfolioPhoto;

    public PortfolioPhotoHolder(View view) {
        super(view);
        tvPortfolioPhotoCaption = view.findViewById(R.id.tvPortfolio);
        ivPortfolioPhoto = view.findViewById(R.id.ivPortfolio);
    }

    public TextView getTvPortfolioPhotoCaption() {
        return tvPortfolioPhotoCaption;
    }

    public ImageView getIvPortfolioPhoto() {
        return ivPortfolioPhoto;
    }
}
