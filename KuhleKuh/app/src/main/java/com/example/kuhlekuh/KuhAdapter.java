package com.example.kuhlekuh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KuhAdapter extends ListAdapter<Kuh, KuhAdapter.KuhHolder> {
    private OnItemClickListener listener;

    public KuhAdapter() {
        super(DIFF_CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Kuh> DIFF_CALLBACK = new DiffUtil.ItemCallback<Kuh>() {
        @Override
        public boolean areItemsTheSame(@NonNull Kuh oldItem, @NonNull Kuh newItem) {
            return oldItem.getId() == newItem. getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Kuh oldItem, @NonNull Kuh newItem) {
            return oldItem.getOhrmarke() == newItem.getOhrmarke() &&
                    oldItem.getEtBehandlung().equals(newItem.getEtBehandlung()) &&
                    oldItem.getEuterentzuendung().equals(newItem.getEuterentzuendung()) &&
                    oldItem.getImpfungKaelberflechte().equals(newItem.getImpfungKaelberflechte()) &&
                    oldItem.getKlauenerkrankung().equals(newItem.getKlauenerkrankung()) &&
                    oldItem.getNabelerkankung().equals(newItem.getNabelerkankung()) &&
                    oldItem.getNachgeburtsverhaltung().equals(newItem.getNachgeburtsverhaltung()) &&
                    oldItem.getTrockenstellen().equals(newItem.getTrockenstellen()) &&
                    oldItem.getSonderbehandlung().equals(newItem.getSonderbehandlung())

                    ;
        }
    };

    @NonNull
    @Override
    public KuhHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kuh_item, parent, false);
        return new KuhHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KuhHolder holder, int position) {
        Kuh currentKuh = getItem(position);

        //  ? "ja" : "nein" ist eine Kurzform von if-else
        holder.textViewOhrmarke.setText(String.valueOf(currentKuh.getOhrmarke()));
        holder.textViewEt.setText(currentKuh.getEtBehandlung() ? "ja" : "nein");
        holder.textViewEut.setText(currentKuh.getEuterentzuendung() ? "ja" : "nein");
        holder.textViewImpf.setText(currentKuh.getImpfungKaelberflechte() ? "ja" : "nein");
        holder.textViewKlaue.setText(currentKuh.getKlauenerkrankung() ? "ja" : "nein");
        holder.textViewNabel.setText(currentKuh.getNabelerkankung() ? "ja" : "nein");
        holder.textViewNachgeb.setText(currentKuh.getNachgeburtsverhaltung() ? "ja" : "nein");
        holder.textViewSonderb.setText(currentKuh.getSonderbehandlung() ? "ja" : "nein");
        holder.textViewTrockenst.setText(currentKuh.getTrockenstellen() ? "ja" : "nein");
    }


    public Kuh getKuhAt(int position) {
        return getItem(position);
    }

    class KuhHolder extends RecyclerView.ViewHolder {
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Kuh kuh);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
