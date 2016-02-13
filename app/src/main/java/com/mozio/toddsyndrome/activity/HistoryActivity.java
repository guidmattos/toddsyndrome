package com.mozio.toddsyndrome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mozio.toddsyndrome.R;
import com.mozio.toddsyndrome.adapter.HistoryAdapter;
import com.mozio.toddsyndrome.model.Patient;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getViews();
        getViewsImpl();
    }

    private void getViews() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewHistory);
    }

    private void getViewsImpl() {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new HistoryAdapter(Patient.getPatients());
        recyclerView.setAdapter(adapter);
    }

}
