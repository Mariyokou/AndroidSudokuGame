package com.example.mari.sudoku.view.buttonsgrid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.example.mari.sudoku.R;

public class ButtonsGridView extends GridView{

    public ButtonsGridView(Context context, AttributeSet attrs) {

        super(context, attrs);

        ButtonsGridViewAdapter gridViewAdapter = new ButtonsGridViewAdapter(context);
        setAdapter(gridViewAdapter);
    }

    class ButtonsGridViewAdapter extends BaseAdapter{
        private Context context;

        public ButtonsGridViewAdapter(Context context){
            this.context = context;
        }

        public int getCount() {
            return 10;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View contentView, ViewGroup parent){
            View v = contentView;
            if (v == null){
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                v = inflater.inflate(R.layout.button, parent, false);

                NumberButton btn;
                btn = (NumberButton)v;
                btn.setTextSize(15);
                btn.setId(position);

                if (position != 9) {
                    btn.setText(String.valueOf(position + 1));
                    btn.setNumber(position + 1);
                }
                else {
                    btn.setText("DEL");
                    btn.setNumber(0);
                }

                return btn;
            }
            return v;
        }
    }
}
