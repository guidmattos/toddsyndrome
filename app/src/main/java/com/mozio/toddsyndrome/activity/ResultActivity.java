package com.mozio.toddsyndrome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mozio.toddsyndrome.R;

public class ResultActivity extends AppCompatActivity {

    private Button buttonHome;
    private TextView textViewResult;
    private double probabilityOfToddSyndrome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getViews();
        getViewsImpl();
    }

    private void getViews() {

        buttonHome = (Button) findViewById(R.id.buttonHome);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
    }

    private void getViewsImpl() {

        probabilityOfToddSyndrome = getIntent().getDoubleExtra("probability", 0.0);

        textViewResult.setText(String.format("%.0f%%", probabilityOfToddSyndrome * 100.0));

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getBaseContext(), MainActivity.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
            }
        });
    }

}
