package com.example.beautymaster.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.beautymaster.models.PortfolioPhoto;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PortfolioPhotoDao {

    @Query("SELECT * FROM PortfolioPhoto")
    Single<List<PortfolioPhoto>> getAll();

    @Insert
    void insert(PortfolioPhoto portfolioPhoto);

    @Insert
    void insertAll(List<PortfolioPhoto> portfolioPhotos);

}
