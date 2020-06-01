package com.example.kuhlekuh;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class KuhRepository {
    private KuhDao kuhDao;
    private LiveData<List<Kuh>> allKuh;

    public KuhRepository(Application application){
        KuhDatabase database = KuhDatabase.getInstance(application);
        kuhDao = database.kuhDao();
        allKuh = kuhDao.getAll();
    }
    public void insertKuh (Kuh kuh){
        new InsertKuhAsyncTask(kuhDao).execute(kuh);
    }
    public void delete (Kuh kuh){
        new UpdateKuhAsyncTask(kuhDao).execute(kuh);
    }
    public void updateKuh (Kuh kuh){
        new DeleteKuhAsyncTask(kuhDao).execute(kuh);
    }
    public LiveData<List<Kuh>> getAllKuh(){
        return allKuh;
    }
    private static class InsertKuhAsyncTask extends AsyncTask<Kuh, Void, Void> {
        private  KuhDao kuhDao;
        private InsertKuhAsyncTask(KuhDao kuhDao){
            this.kuhDao = kuhDao;
        }
        @Override
        protected Void doInBackground(Kuh... kuhs) {
            kuhDao.insertKuh(kuhs[0]);
            return null;
        }
    }
    private static class UpdateKuhAsyncTask extends AsyncTask<Kuh, Void, Void> {
        private  KuhDao kuhDao;
        private UpdateKuhAsyncTask(KuhDao kuhDao){
            this.kuhDao = kuhDao;
        }
        @Override
        protected Void doInBackground(Kuh... kuhs) {
            kuhDao.updateKuh(kuhs[0]);
            return null;
        }
    }
    private static class DeleteKuhAsyncTask extends AsyncTask<Kuh, Void, Void> {
        private  KuhDao kuhDao;
        private DeleteKuhAsyncTask(KuhDao kuhDao){
            this.kuhDao = kuhDao;
        }
        @Override
        protected Void doInBackground(Kuh... kuhs) {
            kuhDao.delete(kuhs[0]);
            return null;
        }
    }
}
