package com.mozio.toddsyndrome.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mozio.toddsyndrome.R;
import com.mozio.toddsyndrome.model.Patient;

import java.util.List;

/**
 * Created by guilhermeduartemattos on 2/13/16.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<Patient> patients;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewAge;
        public TextView textViewGender;
        public TextView textViewMigraines;
        public TextView textViewDrugs;

        public ViewHolder(View v) {
            super(v);
            textViewName = (TextView) v.findViewById(R.id.textViewHistoryName);
            textViewAge = (TextView) v.findViewById(R.id.textViewHistoryAge);
            textViewGender = (TextView) v.findViewById(R.id.textViewHistoryGender);
            textViewMigraines = (TextView) v.findViewById(R.id.textViewHistoryMigraines);
            textViewDrugs = (TextView) v.findViewById(R.id.textViewHistoryDrugs);
        }
    }

    public HistoryAdapter(List patients) {
        this.patients = patients;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewName.setText(patients.get(position).getName());
        holder.textViewAge.setText(String.valueOf(patients.get(position).getAge()));
        holder.textViewGender.setText(patients.get(position).getGender());
        String migraines = patients.get(position).hasMigraines() ? "Yes" : "No";
        holder.textViewMigraines.setText(migraines);
        String drugs = patients.get(position).usedDrugs() ? "Yes" : "No";
        holder.textViewDrugs.setText(drugs);
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }
}
