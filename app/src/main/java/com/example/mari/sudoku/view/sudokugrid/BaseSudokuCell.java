package com.example.mari.sudoku.view.sudokugrid;

import android.content.Context;
import android.view.View;

public class BaseSudokuCell extends View{
    private int value;
    private boolean modifiable = true;

    public BaseSudokuCell(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setNotModifiable() {
        modifiable = false;
    }

    public boolean isNotModifiable() {
        return !this.modifiable;
    }

    public boolean isModifiable() {
        return this.modifiable;
    }

    public void setInitValue(int value) {
        this.value = value;
        invalidate();
    }

    public void setValue(int value) {
        if (modifiable) {
            this.value = value;
        }

        invalidate();
    }

    public int getValue() {
        return value;
    }
}
