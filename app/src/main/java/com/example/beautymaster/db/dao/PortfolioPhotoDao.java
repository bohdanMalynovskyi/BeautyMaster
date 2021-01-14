package com.example.beautymaster.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.beautymaster.models.PortfolioPhoto;

import java.util.List;

@Dao
public interface PortfolioPhotoDao {

    @Query("SELECT * FROM PortfolioPhoto")
    List<PortfolioPhoto> getAll();

    @Insert
    void insert(PortfolioPhoto portfolioPhoto);
}
