package com.example.kuhlekuh;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.RoomDatabase;

import java.util.List;

@Dao
public interface KuhDao {
    @Query("SELECT * FROM Kuh")
    List<Kuh> getAll();

    @Delete
    void delete(Kuh kuh);
}


