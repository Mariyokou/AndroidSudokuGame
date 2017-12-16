package com.example.mari.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityForCongrats extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_congrats);

        Button btnBack = (Button)findViewById(R.id.buttonQuit);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForCongrats.this, MainActivity.class));
            }
        });

        Button btnLevelChoose = (Button)findViewById(R.id.buttonPlay);

        btnLevelChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForCongrats.this, ActivityForLevelChoose.class));
            }
        });

        View root = btnBack.getRootView();
        root.setBackgroundColor(ActivityForOptions.getBackgroundColor());
    }
}
