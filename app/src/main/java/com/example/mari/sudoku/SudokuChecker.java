package com.example.mari.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuChecker {
    private static SudokuChecker instance;

    private SudokuChecker() {}

    public static SudokuChecker getInstance(){
        if(instance == null){
            instance = new SudokuChecker();
        }
        return instance;
    }

    public boolean checkSudoku(int[][] Sudoku) {
        return (checkHorizontally(Sudoku)
            || checkVertically(Sudoku)
            || checkRegionally(Sudoku));
    }

    public boolean checkHorizontally(int[][] Sudoku) {
        for (int y = 0; y < 9; y++){
            Set<Integer> horizontalLine = new HashSet<Integer>();
            for (int x = 0; x < 9; x++){
                if (Sudoku[x][y] == 0 || horizontalLine.contains(Sudoku[x][y])) {
                    return false;
                }
                horizontalLine.add(Sudoku[x][y]);
            }
        }
        return true;
    }

    public boolean checkVertically(int[][] Sudoku) {
        for (int x = 0; x < 9; x++){
            Set<Integer> verticalLine = new HashSet<Integer>();
            for (int y = 0; y < 9; y++){
                if (Sudoku[x][y] == 0 || verticalLine.contains(Sudoku[x][y])) {
                    return false;
                }
                verticalLine.add(Sudoku[x][y]);
            }
        }
        return true;
    }

    public boolean checkRegionally(int[][] Sudoku) {
        for(int xRegion = 0; xRegion < 3; xRegion++){
            for(int yRegion = 0; yRegion < 3; yRegion++){
                if (!checkRegion(Sudoku, xRegion, yRegion)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRegion(int[][] Sudoku, int xRegion, int yRegion) {
        int initialXPos = xRegion * 3;
        int initialYPos = yRegion * 3;
        Set<Integer> region = new HashSet<Integer>();
        for (int x = initialXPos; x < initialXPos + 3; x++) {
            for (int y = initialYPos; y < initialYPos + 3; y++) {
                if (Sudoku[x][y] == 0 || region.contains(Sudoku[x][y])) {
                    return false;
                }
                region.add(Sudoku[x][y]);
            }
        }
        return true;
    }
}
