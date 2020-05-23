package com.example.kuhlekuh.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.kuhlekuh.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        //dynamic table
        TableLayout overviewTable = (TableLayout)root.findViewById(R.id.simpleTableLayout);
        overviewTable.setStretchAllColumns(true);
        overviewTable.bringToFront();
        for(int i = 0; i < 3; i++){
            TableRow tr =  new TableRow(getContext());
            TextView textColumnNr1 = new TextView(getContext());
            textColumnNr1.setText("cowNumber");
            TextView textColumnNr2 = new TextView(getContext());
            textColumnNr2.setText("vaccination");
            TextView textColumnNr3 = new TextView(getContext());
            textColumnNr3.setText("muh");
            tr.addView(textColumnNr1);
            tr.addView(textColumnNr2);
            tr.addView(textColumnNr3);
            overviewTable.addView(tr);
        }

        return root;
    }
}


