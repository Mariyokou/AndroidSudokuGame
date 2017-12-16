package com.example.mari.sudoku;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityForOptions extends AppCompatActivity {
    final Context context = this;
    private Button btnAbout;
    public static String selectedHexColor = "#e0ab74";
    public static int selectedColor = Color.rgb(224, 171, 116);
    public static boolean isMusicOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_options);

        Button btnBack = (Button)findViewById(R.id.buttonBack);
        View root = btnBack.getRootView();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(ActivityForOptions.this, MainActivity.class));
            }
        });

        root.setBackgroundColor(selectedColor);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        List<String> items = new ArrayList<>();
        items.add("#e0ab74");
        items.add("#7092be");
        items.add("#22b14c");
        items.add("#c88ac8");
        items.add("#7f7f7f");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        addListenerOnSpinnerItemSelection(dropdown);
        int colorIndex = items.indexOf(selectedHexColor);
        dropdown.setSelection(colorIndex);

        btnAbout = (Button) findViewById(R.id.buttonAbout);

        btnAbout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.about_popup);

                Button dialogButton = (Button) dialog.findViewById(R.id.buttonClose);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    dialog.dismiss();
                    }
                });

                dialog.show();

                View root = dialogButton.getRootView();

                root.setBackgroundColor(selectedColor);
            }
        });

        Switch onOffSwitch = (Switch)findViewById(R.id.music_switch);
        onOffSwitch.setChecked(isMusicOn);

        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isMusicOn = isChecked;
                if (!isChecked) {
                    stopService(new Intent(ActivityForOptions.this, SoundService.class));
                }
                else {
                    startService(new Intent(ActivityForOptions.this, SoundService.class));
                }
            }

        });
    }

    public static int getBackgroundColor() {
        return selectedColor;
    }

    public static boolean isMusicOn() {
        return isMusicOn;
    }

    private static void setColor(String hexColor, int color, View parent){
        selectedColor = color;
        selectedHexColor = hexColor;
        View root =  parent.getRootView();
        root.setBackgroundColor(color);
    }

    public void addListenerOnSpinnerItemSelection(Spinner dropdown) {
        dropdown.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            switch(parent.getItemAtPosition(pos).toString()) {
                case "#e0ab74":
                    setColor("#e0ab74", Color.rgb(224, 171, 116), parent);
                    break;
                case "#7092be":
                    setColor("#7092be", Color.rgb(112, 146, 190), parent);
                    break;
                case "#22b14c":
                    setColor("#22b14c", Color.rgb(34, 177, 76), parent);
                    break;
                case "#c88ac8":
                    setColor("#c88ac8", Color.rgb(200, 138, 200), parent);
                    break;
                case "#7f7f7f":
                    setColor("#7f7f7f", Color.rgb(127, 127, 127), parent);
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}