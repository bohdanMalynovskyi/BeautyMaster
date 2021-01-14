package com.example.beautymaster.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.beautymaster.models.Service;

import java.util.List;

@Dao
public interface ServiceDao {

    @Query("SELECT * FROM service")
    List<Service> getAll();

    @Insert
    void insert(Service service);

}
