package com.example.kuhlekuh;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class KuhViewModel extends AndroidViewModel {
    private KuhRepository repository;
    private LiveData<List<Kuh>> getAll;

    public KuhViewModel(@NonNull Application application) {
        super(application);
        repository = new KuhRepository(application);
        getAll = repository.getAllKuh();
    }
    public void insertKuh(Kuh kuh){
        repository.insertKuh(kuh);
    }
    public void updateKuh(Kuh kuh){
        repository.updateKuh(kuh);
    }
    public void delete(Kuh kuh){
        repository.delete(kuh);
    }

    public void deleteAllKuhs() {
        repository.deleteAllKuhs();
    }

    public LiveData<List<Kuh>> getGetAll() {
        return getAll;
    }
}
