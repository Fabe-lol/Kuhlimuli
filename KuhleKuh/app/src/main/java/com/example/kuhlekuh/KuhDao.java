package com.example.kuhlekuh;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Dao
public interface KuhDao {
    @Query("SELECT * FROM Kuh")
    List<Kuh> getAll();
    @Insert
    void insertKuh(Kuh kuh);
    @Update
    void updatePerson(Kuh kuh);
    @Delete
    void delete(Kuh kuh);
}


