package com.example.kuhlekuh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KuhAdapter extends RecyclerView.Adapter<KuhAdapter.KuhHolder> {
    private List<Kuh> kuh = new ArrayList<>();

    @NonNull
    @Override
    public KuhHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_notifications, parent, false);
        return new KuhHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KuhHolder holder, int position) {
        Kuh currentKuh = kuh.get(position);
        holder.textViewOhrmarke.setText(String.valueOf(currentKuh.getOhrmarke()));
        //hier die Abfrage nach booelans funzt noch nicht
        //holder.textViewBehandlung.setText("etBehandlung: " + currentKuh.getEtBehandlung().toString());
        holder.textViewet.setText(String.format("ET durchgeführt :%s", currentKuh.getEtBehandlung()));
    }

    @Override
    public int getItemCount() {
        return kuh.size();
    }
    public void setKuh(List<Kuh> kuhs){

        this.kuh = kuhs;
        notifyDataSetChanged();
    }
    class KuhHolder extends RecyclerView.ViewHolder{

        private TextView textViewBehandlung;
        private TextView textViewet;
        private TextView textViewOhrmarke;

        public KuhHolder(@NonNull View itemView) {
            super(itemView);
            textViewBehandlung = itemView.findViewById(R.id.text_view_eut);
            textViewet = itemView.findViewById(R.id.text_view_et);
            textViewOhrmarke = itemView.findViewById(R.id.text_view_ohrmarke);
        }
    }
}
