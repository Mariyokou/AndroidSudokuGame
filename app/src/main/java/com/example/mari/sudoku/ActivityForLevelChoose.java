package com.example.mari.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class ActivityForLevelChoose extends AppCompatActivity {
    NumberPicker np;
    TextView tv1;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_level_choose);

        Button btnPlay = (Button)findViewById(R.id.buttonPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SudokuGenerator.setEmptyElementCount(number);
                startActivity(new Intent(ActivityForLevelChoose.this, ActivityForPlay.class));
            }
        });

        Button btnBack = (Button)findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForLevelChoose.this, MainActivity.class));
            }
        });

        np = (NumberPicker) findViewById(R.id.numberpicker);
        tv1 = (TextView) findViewById(R.id.numberview);

        np.setMinValue(0);
        np.setMaxValue(80);
        np.setWrapSelectorWheel(false);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String textNew = "COMPLEXITY: ";
                number = newVal;

                if (69 < newVal && newVal <= 80) {
                    tv1.setText(textNew.concat("VERY EASY"));
                }
                else if (56 < newVal && newVal <= 69) {
                    tv1.setText(textNew.concat("EASY"));
                }
                else if (25 < newVal && newVal <= 56) {
                    tv1.setText(textNew.concat("MEDIUM"));
                }
                else if (10 < newVal && newVal <= 25) {
                    tv1.setText(textNew.concat("HARD"));
                }
                else {
                    tv1.setText(textNew.concat("VERY HARD"));
                }
            }
        });

        View root = btnBack.getRootView();
        root.setBackgroundColor(ActivityForOptions.getBackgroundColor());
    }
}
