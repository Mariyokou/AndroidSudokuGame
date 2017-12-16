package com.example.mari.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent svc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLevelChoose = (Button)findViewById(R.id.buttonLevelChoose);

        View root = btnLevelChoose.getRootView();
        root.setBackgroundColor(ActivityForOptions.getBackgroundColor());

        btnLevelChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, ActivityForLevelChoose.class));
            }
        });

        Button btnOptions = (Button)findViewById(R.id.buttonOptions);

        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, ActivityForOptions.class));
            }
        });

        Button btnRules = (Button)findViewById(R.id.buttonRules);

        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, ActivityForRules.class));
            }
        });

        Button btnQuit = (Button)findViewById(R.id.buttonQuit);

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            }
        });

        svc = new Intent(this, SoundService.class);
        if (ActivityForOptions.isMusicOn()) {
            startService(svc);
        }
        else {
            stopService(svc);
        }
    }
}
