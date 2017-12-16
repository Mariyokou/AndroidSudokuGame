package com.example.mari.sudoku.view.sudokugrid;

import android.content.Context;
import android.content.Intent;

import com.example.mari.sudoku.ActivityForCongrats;
import com.example.mari.sudoku.SudokuChecker;

public class GameGrid {
    private SudokuCell[][] Sudoku = new SudokuCell[9][9];
    private Context context;
    private int currentItemX = -1;
    private int currentItemY = -1;

    public GameGrid(Context context){
        this.context = context;
        for(int x = 0; x < 9; x++){
            for(int y = 0; y< 9; y++){
                Sudoku[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for(int x = 0; x < 9; x++){
            for(int y = 0; y< 9; y++){
                Sudoku[x][y].setInitValue(grid[x][y]);
                if (grid[x][y] != 0){
                    Sudoku[x][y].setNotModifiable();
                }
            }
        }
    }

    public SudokuCell getItem(int x, int y) {
        return Sudoku[x][y];
    }

    public SudokuCell getItem(int position) {
        int x = position % 9;
        int y = position / 9;

        return Sudoku[x][y];
    };

    public void setItem(int x, int y, int number) {
        Sudoku[x][y].setValue(number);
    }

    public void setActiveItem(int x, int y) {
        unselectItem();

        currentItemX = x;
        currentItemY = y;
        SudokuCell currentCell = getItem(currentItemX, currentItemY);
        if (currentCell.isModifiable()) {
            currentCell.setCellSelection(true);
            currentCell.invalidate();
        }
    }

    public void unselectItem() {
        if (currentItemX != -1 && currentItemY != -1) {
            SudokuCell currentCell = getItem(currentItemX, currentItemY);
            currentCell.setCellSelection(false);
            currentCell.invalidate();
        }
        currentItemX = -1;
        currentItemY = -1;
    }

    public void checkGame() {
        int[][] sudGrid = new int[9][9];

        for(int x =0; x<9; x++){
            for(int y =0; y<9; y++){
                sudGrid[x][y] = getItem(x, y).getValue();
            }
        }

        if(SudokuChecker.getInstance().checkSudoku(sudGrid)) {
            context.startActivity(new Intent(context, ActivityForCongrats.class));
        }
    }

    public SudokuCell[][] restartGrid() {
        for(int x =0; x<9; x++){
            for(int y =0; y<9; y++){
                if(getItem(x, y).isModifiable()) {
                    Sudoku[x][y].setValue(0);
                }
            }
        }
        return Sudoku;
    }
}
