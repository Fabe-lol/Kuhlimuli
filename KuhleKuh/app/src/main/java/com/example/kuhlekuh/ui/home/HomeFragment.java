package com.example.kuhlekuh.ui.home;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.example.kuhlekuh.Kuh;
import com.example.kuhlekuh.KuhDatabase;
import com.example.kuhlekuh.R;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.List;


public class HomeFragment extends Fragment {
    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;
    private HomeViewModel homeViewModel;
    private Button saveButtonHome;
    private TextView testTextView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //TODO: use singleton pattern
        final KuhDatabase kuhDb = Room.databaseBuilder(getActivity(), KuhDatabase.class, "database-name").build();

        //Startdatum Datepicker
        mDisplayDate = (TextView) root.findViewById(R.id.tvDate);
                mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        // Enddatum Datepicker
        mDisplayDate2 = (TextView) root.findViewById(R.id.tvDate2);
        mDisplayDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        //Startdatum Datepicker
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd.mm.yyy: " + day + "." + month + "." + year);

                String date = day + "." + month + "." + year;
                mDisplayDate.setText(date);
            }
        };

        // Enddatum Datepicker
        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd.mm.yyy: " + day + "." + month + "." + year);

                String date = day + "." + month + "." + year;
                mDisplayDate2.setText(date);
            }
        };

        //Save button
        saveButtonHome = (Button) root.findViewById(R.id.save_button_home);
        testTextView = (TextView) root.findViewById(R.id.testTextView);
        saveButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                Kuh myKuh = new Kuh();
                myKuh.ohrmarke = 123;
                myKuh.etBehandlung = false;
                kuhDb.userDao().insertKuh(myKuh);
                List<Kuh> listKuh = kuhDb.userDao().getAll();
                Kuh anotherKuh = new Kuh();
                anotherKuh = listKuh.get(0);
                testTextView.setText(Integer.toString(anotherKuh.ohrmarke));*/
            }
        });
        return root;
    }
}

