package com.example.mari.sudoku.view.sudokugrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SudokuCell extends BaseSudokuCell{
    private Paint mPaint;

    static int instanceCount;
    private int x;
    private int y;
    private boolean selected = false;

    public SudokuCell(Context context){
        super(context);

        mPaint = new Paint();

        if (instanceCount >= 81) {
            instanceCount = 0;
        }

        x = instanceCount / 9;
        y = instanceCount % 9;
        instanceCount++;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (this.isNotModifiable()) {
            drawReadonlyCells(canvas);
        }

        if (selected) {
            drawSelectedLines(canvas);
        }
        else {
            drawLines(canvas);
        }

        if (x == 2 || x == 5) {
            drawThickLines(canvas, 'x');
        }
        if (y == 2 || y == 5) {
            drawThickLines(canvas, 'y');
        }

        drawNumber(canvas);
    }

    public void setCellSelection(boolean selection) {
        selected = selection;
    }

    private void drawNumber(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(40);
        mPaint.setStyle(Paint.Style.FILL);

        Rect bounds = new Rect();
        mPaint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);

        if (getValue() != 0) {
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width()/2 - 30),
                    (getHeight() + bounds.height()/2 - 25), mPaint);
        }
    }

    private void drawReadonlyCells(Canvas canvas){
        mPaint.setColor(Color.rgb(232, 232, 232));
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }

    private void drawLines(Canvas canvas){
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }

    private void drawSelectedLines(Canvas canvas){
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }

    private void drawThickLines(Canvas canvas, char position){
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(12);
        mPaint.setStyle(Paint.Style.STROKE);
        if (position == 'x') {
            canvas.drawRect(-10, -10, getWidth(), getHeight()*2, mPaint);
        }
        else if (position == 'y') {
            canvas.drawRect(-10, -10, getWidth() * 2, getHeight(), mPaint);
        }
    }
}

