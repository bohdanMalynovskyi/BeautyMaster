package com.example.beautymaster.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beautymaster.R
import com.example.beautymaster.holder.PortfolioPhotoHolder
import com.example.beautymaster.models.PortfolioPhoto
import com.squareup.picasso.Picasso

class PortfolioPhotoAdapter(var portfolioPhotos: List<PortfolioPhoto>) : RecyclerView.Adapter<PortfolioPhotoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioPhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.portfolio_item, parent, false)
        return PortfolioPhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PortfolioPhotoHolder, position: Int) {
        val portfolioPhoto = portfolioPhotos[position]
        holder.tvPortfolioPhotoCaption.text = portfolioPhoto.caption
        Picasso.get()
                .load(portfolioPhoto.photoUrl)
                .placeholder(R.drawable.ic_placeholder)
                .into(holder.ivPortfolioPhoto)
    }

    override fun getItemCount(): Int {
        return portfolioPhotos.size
    }

}