package com.example.mari.sudoku.view.buttonsgrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.mari.sudoku.GameEngine;

public class NumberButton extends Button implements OnClickListener{
    private int number;

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    public void onClick(View v) {
        GameEngine.getInstance().setNumber(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
