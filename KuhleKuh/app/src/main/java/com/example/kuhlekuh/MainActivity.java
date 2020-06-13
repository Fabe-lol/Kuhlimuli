package com.example.kuhlekuh;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    //KuhDatabase kuhDb = Room.databaseBuilder(getApplicationContext(), KuhDatabase.class, "database-name").build();

// Neues KuhViewModel
    private KuhViewModel kuhViewModel;
    public static final int ADD_KUH_REQUEST =1;
    public static final int EDIT_KUH_REQUEST =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton buttonAddKuh = findViewById(R.id.button_add_kuh);
        buttonAddKuh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditKuhActivity.class);
                startActivityForResult(intent, ADD_KUH_REQUEST);
            }
        });

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
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                kuhViewModel.delete(adapter.getKuhAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Kuh gelöscht", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new KuhAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Kuh kuh) {
                Intent intent = new Intent(MainActivity.this, AddEditKuhActivity.class);
                intent.putExtra(AddEditKuhActivity.EXTRA_ID, kuh.getId());
                intent.putExtra(AddEditKuhActivity.EXTRA_OHRMARKE, kuh.getOhrmarke());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_ET, kuh.getEtBehandlung());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_EUTER, kuh.getEuterentzuendung());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_IMPFUNG, kuh.getImpfungKaelberflechte());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_KLAUEN, kuh.getKlauenerkrankung());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_NABEL, kuh.getNabelerkankung());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_NACHGEB, kuh.getNachgeburtsverhaltung());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_SONDER, kuh.getSonderbehandlung());
                intent.putExtra(AddEditKuhActivity.EXTRA_CHECKBOX_TROCKENST, kuh.getTrockenstellen());
                startActivityForResult(intent, EDIT_KUH_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_KUH_REQUEST && resultCode == RESULT_OK){
            String sOhrmarke = data.getStringExtra(AddEditKuhActivity.EXTRA_OHRMARKE);
            boolean bEtbehandlung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_ET, false);
            boolean bEuterentzuendung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_EUTER, false);
            boolean bImpfungKaelberflechte = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_IMPFUNG, false);
            boolean bKlauenerkrankung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_KLAUEN, false);
            boolean bNabelerkankung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_NABEL, false);
            boolean bNachgeburtsverhaltung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_NACHGEB, false);
            boolean bSonderbehandlung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_SONDER, false);
            boolean bTrockenstellen = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_TROCKENST, false);

            int iOhrmarke = Integer.parseInt(sOhrmarke);

            Kuh kuh = new Kuh(iOhrmarke,bEtbehandlung, bEuterentzuendung, bImpfungKaelberflechte,
                    bKlauenerkrankung, bNabelerkankung, bNachgeburtsverhaltung, bSonderbehandlung,
                    bTrockenstellen);

            kuhViewModel.insertKuh(kuh);
            Toast.makeText(this, "Kuh Saved", Toast.LENGTH_SHORT).show();
        }
        else if (requestCode == EDIT_KUH_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(AddEditKuhActivity.EXTRA_ID, -1);
            if (id == -1){
                Toast.makeText(this, "Kuh konnte nicht geupdated werden", Toast.LENGTH_SHORT).show();
                return;
            }
            String sOhrmarke = data.getStringExtra(AddEditKuhActivity.EXTRA_OHRMARKE);
            boolean bEtbehandlung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_ET, false);
            boolean bEuterentzuendung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_EUTER, false);
            boolean bImpfungKaelberflechte = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_IMPFUNG, false);
            boolean bKlauenerkrankung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_KLAUEN, false);
            boolean bNabelerkankung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_NABEL, false);
            boolean bNachgeburtsverhaltung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_NACHGEB, false);
            boolean bSonderbehandlung = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_SONDER, false);
            boolean bTrockenstellen = data.getBooleanExtra(AddEditKuhActivity.EXTRA_CHECKBOX_TROCKENST, false);

            int iOhrmarke = Integer.parseInt(sOhrmarke);
            Kuh kuh = new Kuh(iOhrmarke,bEtbehandlung, bEuterentzuendung, bImpfungKaelberflechte,
                    bKlauenerkrankung, bNabelerkankung, bNachgeburtsverhaltung, bSonderbehandlung,
                    bTrockenstellen);
            kuh.setId(id);
            kuhViewModel.updateKuh(kuh);
            Toast.makeText(this, "Kuh updated", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Kuh not saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_kuhs:
                kuhViewModel.deleteAllKuhs();
                Toast.makeText(this, "Alle Kühe gelöscht", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
