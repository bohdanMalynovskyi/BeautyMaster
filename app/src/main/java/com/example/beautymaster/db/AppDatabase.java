package com.example.beautymaster.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.beautymaster.db.dao.PortfolioPhotoDao;
import com.example.beautymaster.db.dao.ServiceDao;
import com.example.beautymaster.models.PortfolioPhoto;
import com.example.beautymaster.models.Service;

@Database(entities = {Service.class, PortfolioPhoto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ServiceDao serviceDao();

    public abstract PortfolioPhotoDao portfolioPhotoDao();
}
