package com.example.kuhlekuh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddKuhActivity extends AppCompatActivity {
    public static final String EXTRA_BEHANDLUNG =
            "com.example.kuhlekuh.EXTRA_BEHANDLUNG";
    public static final String EXTRA_OHRMARKE =
            "com.example.kuhlekuh.EXTRA_OHRMARKE";
    private EditText editTextBehandlung;
    private EditText editOhrmakre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kuh);

        editTextBehandlung = findViewById(R.id.edit_text_behandlung);
        editOhrmakre = findViewById(R.id.number_ohrmarke);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Kuh");
    }
    private void saveKuh(){
        String behandlung = editTextBehandlung.getText().toString();
        String ohrmarke = editOhrmakre.getText().toString();
        if (behandlung.trim().isEmpty()||ohrmarke.trim().isEmpty()){
            Toast.makeText(this, "Please insert Behandlung und Ohrmarke", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_BEHANDLUNG, behandlung);
        data.putExtra(EXTRA_OHRMARKE, ohrmarke);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_kuh_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_kuh:
                saveKuh();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
