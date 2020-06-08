package com.example.kuhlekuh;

import androidx.lifecycle.LiveData;
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
    @Query("SELECT * FROM kuh ORDER BY ohrmarke ASC") //geordnet nach Ohrmarken nummer
    LiveData<List<Kuh>> getAll(); //live Data
    @Insert
    void insertKuh(Kuh kuh);
    @Update
    void updateKuh(Kuh kuh);
    @Delete
    void delete(Kuh kuh);
    @Query("DELETE FROM kuh")
    void deleteAllKuhs();
}


