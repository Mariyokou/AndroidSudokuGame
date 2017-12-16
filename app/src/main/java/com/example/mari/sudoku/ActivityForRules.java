package com.example.mari.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityForRules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_rules);

        Button btnBack = (Button)findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForRules.this, MainActivity.class));
            }
        });

        View root = btnBack.getRootView();
        root.setBackgroundColor(ActivityForOptions.getBackgroundColor());
    }
}
