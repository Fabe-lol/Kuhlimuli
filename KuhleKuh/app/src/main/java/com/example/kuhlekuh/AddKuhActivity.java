package com.example.kuhlekuh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddKuhActivity extends AppCompatActivity {
    public static final String EXTRA_BEHANDLUNG =
            "com.example.kuhlekuh.EXTRA_BEHANDLUNG";
    public static final String EXTRA_OHRMARKE =
            "com.example.kuhlekuh.EXTRA_OHRMARKE";
    public static final String EXTRA_CHECKBOX1 =
            "com.example.kuhlekuh.EXTRA_CHECKBOX1";
    private EditText editTextBehandlung;
    private EditText editOhrmakre;
    
    private CheckBox etBehandlung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kuh);

        editTextBehandlung = findViewById(R.id.edit_text_behandlung);
        editOhrmakre = findViewById(R.id.number_ohrmarke);

        etBehandlung = (CheckBox)findViewById(R.id.checkBox1);
        etBehandlung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Kuh");
    }
    private void saveKuh(){
        String behandlung = editTextBehandlung.getText().toString();
        String ohrmarke = editOhrmakre.getText().toString();
        String etbehandlung = etBehandlung.getText().toString();
        //on Klick Listener finzt nicht, weiß nicht wie ich den wert in EXTRA CHECKBOX zu nem string machen kann
        if (etBehandlung.isChecked()){
                
                Toast.makeText(AddKuhActivity.this, "ETBehandlung ausgewählt", Toast.LENGTH_SHORT).show();

        }


        if (ohrmarke.trim().isEmpty()){
            Toast.makeText(this, "Please insert Ohrmarke", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_BEHANDLUNG, behandlung);
        data.putExtra(EXTRA_OHRMARKE, ohrmarke);
        data.putExtra(EXTRA_CHECKBOX1, etbehandlung);

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
