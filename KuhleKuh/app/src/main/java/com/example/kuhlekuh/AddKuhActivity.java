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

    public static final String EXTRA_OHRMARKE =
            "com.example.kuhlekuh.EXTRA_OHRMARKE";
    public static final String EXTRA_CHECKBOX_ET =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_ET";
    public static final String EXTRA_CHECKBOX_EUTER =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_EUTER";
    public static final String EXTRA_CHECKBOX_IMPFUNG =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_IMPFUNG";
    public static final String EXTRA_CHECKBOX_KLAUEN =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_KLAUEN";
    public static final String EXTRA_CHECKBOX_NABEL =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_NABEL";
    public static final String EXTRA_CHECKBOX_NACHGEB =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_NACHGEB";
    public static final String EXTRA_CHECKBOX_SONDER =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_SONDER";
    public static final String EXTRA_CHECKBOX_TROCKENST =
            "com.example.kuhlekuh.EXTRA_CHECKBOX_TROCKENST";
    private EditText editOhrmarke;
    private CheckBox etBehandlung;
    private CheckBox euterentzuendung;
    private CheckBox impfungKaelberflechte;
    private CheckBox klauenerkrankung;
    private CheckBox nabelerkankung;
    private CheckBox nachgeburtsverhaltung;
    private CheckBox sonderbehandlung;
    private CheckBox trockenstellen;
    private View tempView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kuh);

        //Obere Leiste im Layout
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Kuh");

        //layout variables
        editOhrmarke = findViewById(R.id.number_ohrmarke);
        etBehandlung = (CheckBox)findViewById(R.id.checkBox_et);
        euterentzuendung = (CheckBox)findViewById(R.id.checkBox_eut);
        impfungKaelberflechte = (CheckBox)findViewById(R.id.checkBox_impf);
        klauenerkrankung = (CheckBox)findViewById(R.id.checkBox_klaue);
        nabelerkankung = (CheckBox)findViewById(R.id.checkBox_nabel);
        nachgeburtsverhaltung = (CheckBox)findViewById(R.id.checkBox_nachgeb);
        sonderbehandlung = (CheckBox)findViewById(R.id.checkBox_sonderb);
        trockenstellen = (CheckBox)findViewById(R.id.checkBox_trockenst);

        //Datepicker von
        Button buttonVon = (Button) findViewById(R.id.button_von);
        buttonVon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempView = v;
                DialogFragment datePickerVon = new DatePickerFragment();
                datePickerVon.show(getSupportFragmentManager(), "date picker von");
            }
        });

        //Datepicker bis
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
        String ohrmarke = editOhrmarke.getText().toString();
        boolean bEtBehandlung = etBehandlung.isChecked();
        boolean bEuterentzuendung = euterentzuendung.isChecked();
        boolean bImpfungKaelberflechte = impfungKaelberflechte.isChecked();
        boolean bKlauenerkrankung = klauenerkrankung.isChecked();
        boolean bNabelerkankung = nabelerkankung.isChecked();
        boolean bNachgeburtsverhaltung = nachgeburtsverhaltung.isChecked();
        boolean bSonderbehandlung = sonderbehandlung.isChecked();
        boolean bTrockenstellen = trockenstellen.isChecked();

        //Leerzeichen und nicht ausgefüllte Ohrmarke abfangen
        if (ohrmarke.trim().isEmpty()){
            Toast.makeText(this, "Please insert Ohrmarke", Toast.LENGTH_SHORT).show();
            return;
        }

        //send back to Main Activity
        Intent data = new Intent();
        data.putExtra(EXTRA_OHRMARKE, ohrmarke);
        data.putExtra(EXTRA_CHECKBOX_ET, bEtBehandlung);
        data.putExtra(EXTRA_CHECKBOX_EUTER, bEuterentzuendung);
        data.putExtra(EXTRA_CHECKBOX_IMPFUNG, bImpfungKaelberflechte);
        data.putExtra(EXTRA_CHECKBOX_KLAUEN, bKlauenerkrankung);
        data.putExtra(EXTRA_CHECKBOX_NABEL, bNabelerkankung);
        data.putExtra(EXTRA_CHECKBOX_NACHGEB, bNachgeburtsverhaltung);
        data.putExtra(EXTRA_CHECKBOX_SONDER, bSonderbehandlung);
        data.putExtra(EXTRA_CHECKBOX_TROCKENST, bTrockenstellen);
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
