package com.example.kuhlekuh;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    //KuhDatabase kuhDb = Room.databaseBuilder(getApplicationContext(), KuhDatabase.class, "database-name").build();

// Neues KuhViewModel
    private KuhViewModel kuhViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recykler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final KuhAdapter adapter = new KuhAdapter();
        recyclerView.setAdapter(adapter);
        //KuhViewModel
        kuhViewModel = ViewModelProviders.of(this).get(KuhViewModel.class);
        kuhViewModel.getGetAll().observe(this, new Observer<List<Kuh>>() {
            @Override
            public void onChanged(List<Kuh> kuhs) {
                adapter.setKuh(kuhs);

            }
        });
    }

}
