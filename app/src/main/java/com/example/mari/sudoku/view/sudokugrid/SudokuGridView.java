package com.example.mari.sudoku.view.sudokugrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.mari.sudoku.GameEngine;
import com.example.mari.sudoku.SudokuGenerator;

public class SudokuGridView extends GridView{
    private final Context context;

    public SudokuGridView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);

        setAdapter(gridViewAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            int x = position % SudokuGenerator.sizeM;
            int y = position / SudokuGenerator.sizeM;

            GameEngine.getInstance().setSelectedPos(x, y);
            invalidate();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    class SudokuGridViewAdapter extends BaseAdapter {
        private Context context;
        private int size = SudokuGenerator.sizeM;

        public SudokuGridViewAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return size*size;
        }

        public Object getItem(int arg0){
            return null;
        }

        public long getItemId(int arg0){
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            return GameEngine.getInstance().getGrid().getItem(position);
        }
    }
}
