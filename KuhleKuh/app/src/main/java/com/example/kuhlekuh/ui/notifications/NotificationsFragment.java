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

        TableLayout prices = (TableLayout)root.findViewById(R.id.simpleTableLayout);
        prices.setStretchAllColumns(true);
        prices.bringToFront();
        for(int i = 0; i < 3; i++){
            TableRow tr =  new TableRow(getContext());
            TextView c1 = new TextView(getContext());
            c1.setText("cowNumber");
            TextView c2 = new TextView(getContext());
            c2.setText("vaccination");
            TextView c3 = new TextView(getContext());
            c3.setText("muh");
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            prices.addView(tr);
        }

        return root;
    }
}


