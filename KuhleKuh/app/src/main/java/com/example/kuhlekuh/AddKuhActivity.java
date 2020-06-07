package com.example.kuhlekuh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class AddKuhActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static final String EXTRA_BEHANDLUNG =
            "com.example.kuhlekuh.EXTRA_BEHANDLUNG";
    public static final String EXTRA_OHRMARKE =
            "com.example.kuhlekuh.EXTRA_OHRMARKE";
    public static final String EXTRA_CHECKBOX1 =
            "com.example.kuhlekuh.EXTRA_CHECKBOX1";
    private EditText editOhrmarke;
    private CheckBox etBehandlung;
    private View tempView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kuh);

        editOhrmarke = findViewById(R.id.number_ohrmarke);

        etBehandlung = (CheckBox)findViewById(R.id.checkBox_et);
        etBehandlung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Kuh");

        Button buttonVon = (Button) findViewById(R.id.button_von);
        buttonVon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempView = v;
                DialogFragment datePickerVon = new DatePickerFragment();
                datePickerVon.show(getSupportFragmentManager(), "date picker von");
            }
        });

        Button buttonBis = (Button) findViewById(R.id.button_bis);
        buttonBis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempView = v;
                DialogFragment datePickerBis = new DatePickerFragment();
                datePickerBis.show(getSupportFragmentManager(), "date picker bis");
            }
        });
    }

    private void saveKuh(){
        String behandlung = "dummyString";
        String ohrmarke = editOhrmarke.getText().toString();
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

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.YEAR, year);
        tempCalendar.set(Calendar.MONTH, month);
        tempCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        if(tempView.getId() == R.id.button_von){
            String currentDateString = DateFormat.getDateInstance().format(tempCalendar.getTime());
            TextView textView_Von = (TextView) findViewById(R.id.text_view_von);
            textView_Von.setText(currentDateString);
        }
        else {
            String currentDateString = DateFormat.getDateInstance().format(tempCalendar.getTime());
            TextView textView_Bis = (TextView) findViewById(R.id.text_view_bis);
            textView_Bis.setText(currentDateString);
        }
    }



}
