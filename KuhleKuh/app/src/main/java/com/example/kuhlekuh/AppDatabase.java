package com.example.kuhlekuh;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Kuh.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract KuhDao userDao();
}
