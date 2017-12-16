package com.example.mari.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ActivityForPlay extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_play);

        GameEngine.getInstance().createGrid(this);

        Button btnMenu = (Button)findViewById(R.id.buttonMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForPlay.this, MainActivity.class));
            }
        });

        Button btnRestart = (Button)findViewById(R.id.buttonRestart);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               GameEngine.getInstance().getGrid().restartGrid();
            }
        });

        Button btnNewGame = (Button)findViewById(R.id.buttonNewGame);

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityForPlay.this.recreate();
            }
        });

        View root = btnMenu.getRootView();
        root.setBackgroundColor(ActivityForOptions.getBackgroundColor());
    }
}


