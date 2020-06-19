package com.example.kuhlekuh;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Kuh.class}, version = 1)
public abstract class KuhDatabase extends RoomDatabase {

    private static KuhDatabase instance;//create a singleton, um nicht mehrere versionen der Datenbank zu erzeugen

    public abstract KuhDao kuhDao();

    public static synchronized KuhDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    KuhDatabase.class,  "KuhDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;

    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private KuhDao kuhDao;
        private PopulateDbAsyncTask(KuhDatabase db){
            kuhDao = db.kuhDao();
        }
        @Override
        protected Void doInBackground(Void... voids){
            kuhDao.insertKuh(new Kuh( 12, true, false, false, false, false, false, false, false));
            kuhDao.insertKuh(new Kuh( 2, false, true, false, false, false, false, false, false));
            return null;
        }
    }

}
