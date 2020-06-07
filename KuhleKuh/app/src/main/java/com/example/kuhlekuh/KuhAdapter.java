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
        //TODO: ternary operator nutzen, um deutsches "ja" und "nein" auszugeben
        holder.textViewEt.setText(currentKuh.getEtBehandlung().toString());
        holder.textViewEut.setText(currentKuh.getEuterentzuendung().toString());
        holder.textViewImpf.setText(currentKuh.getImpfungKaelberflechte().toString());
        holder.textViewKlaue.setText(currentKuh.getKlauenerkrankung().toString());
        holder.textViewNabel.setText(currentKuh.getNabelerkankung().toString());
        holder.textViewNachgeb.setText(currentKuh.getNachgeburtsverhaltung().toString());
        holder.textViewSonderb.setText(currentKuh.getSonderbehandlung().toString());
        holder.textViewTrockenst.setText(currentKuh.getTrockenstellen().toString());
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
        private TextView textViewOhrmarke;
        private TextView textViewEt;
        private TextView textViewEut;
        private TextView textViewImpf;
        private TextView textViewKlaue;
        private TextView textViewNabel;
        private TextView textViewNachgeb;
        private TextView textViewSonderb;
        private TextView textViewTrockenst;

        public KuhHolder(@NonNull View itemView) {
            super(itemView);
            textViewOhrmarke = itemView.findViewById(R.id.text_view_ohrmarke);
            textViewEt = itemView.findViewById(R.id.text_et_date);
            textViewEut = itemView.findViewById(R.id.text_view_eut_date);
            textViewImpf = itemView.findViewById(R.id.text_view_impf_date);
            textViewKlaue = itemView.findViewById(R.id.text_view_klaue_date);
            textViewNabel = itemView.findViewById(R.id.text_view_nabel_date);
            textViewNachgeb = itemView.findViewById(R.id.text_view_nachgeb_date);
            textViewSonderb = itemView.findViewById(R.id.text_view_sonderb_date);
            textViewTrockenst = itemView.findViewById(R.id.text_view_trockenst_date);
        }
    }
}
