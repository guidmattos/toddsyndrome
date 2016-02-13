package com.mozio.toddsyndrome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mozio.toddsyndrome.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();
        getViewsImpl();
    }

    private void getViews() {

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonHistory = (Button) findViewById(R.id.buttonHistory);
    }

    private void getViewsImpl() {
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuestionsIntent = new Intent(getBaseContext(), QuestionsActivity.class);
                startActivity(startQuestionsIntent);
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuestionsIntent = new Intent(getBaseContext(), HistoryActivity.class);
                startActivity(startQuestionsIntent);
            }
        });
    }

}
