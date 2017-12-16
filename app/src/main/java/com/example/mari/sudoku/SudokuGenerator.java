package com.example.mari.sudoku;

import java.util.ArrayList;
import java.util.Random;

public class SudokuGenerator {
    private static SudokuGenerator instance;
    private ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();
    private Random rand = new Random();

    public static int sizeM = 9;
    public static int emptyElementCount = 81;

    private SudokuGenerator() {
    }

    public static void setEmptyElementCount(int count) {
        emptyElementCount = 81 - count;
    }

    public static SudokuGenerator getInstance() {
        if (instance == null) {
            instance = new SudokuGenerator();
        }
        return instance;
    }

    public int[][] generateGrid() {
        int sizeM = SudokuGenerator.sizeM;
        int currentPos = 0;

        int[][] SudokuBoard = new int[sizeM][sizeM];

        clearGrid(SudokuBoard);

        while (currentPos < sizeM * sizeM) {
            if (Available.get(currentPos).size() != 0) {
                int i = rand.nextInt(Available.get(currentPos).size());
                int number = Available.get(currentPos).get(i);

                if (!isConflict(SudokuBoard, currentPos, number)) {
                    int xPos = currentPos % sizeM;
                    int yPos = currentPos / sizeM;

                    SudokuBoard[xPos][yPos] = number;

                    Available.get(currentPos).remove(i);

                    currentPos++;
                } else {
                    Available.get(currentPos).remove(i);
                }
            } else {
                for (int i = 1; i <= sizeM; i++) {
                    Available.get(currentPos).add(i);
                }
                currentPos--;
            }
        }

        return SudokuBoard;
    }

    public int[][] removeElements(int[][] Sudoku) {
        int i = 0;

        while (i < emptyElementCount) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);

            if (Sudoku[x][y] != 0) {
                Sudoku[x][y] = 0;
                i++;
            }
        }
        return Sudoku;
    }

    private void clearGrid(int[][] SudokuBoard) {
        int size = SudokuGenerator.sizeM;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                SudokuBoard[x][y] = -1;
            }
        }

        for (int x = 0; x < size * size; x++) {
            Available.add(new ArrayList<Integer>());
            for (int i = 1; i <= size; i++) {
                Available.get(x).add(i);
            }
        }
    }

    private boolean isConflict(int[][] SudokuBoard, int currentPos, final int number) {
        int sizeM = SudokuGenerator.sizeM;
        int xPos = currentPos % sizeM;
        int yPos = currentPos / sizeM;

        return isHorizontalConflict(SudokuBoard, xPos, yPos, number)
                || isVerticalConflict(SudokuBoard, xPos, yPos, number)
                || isRegionConflict(SudokuBoard, xPos, yPos, number);
    }

    private boolean isHorizontalConflict(final int[][] SudokuBoard, final int xPos, final int yPos, final int number) {
        for (int x = xPos - 1; x >= 0; x--) {
            if (number == SudokuBoard[x][yPos]) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalConflict(final int[][] SudokuBoard, final int xPos, final int yPos, final int number) {
        for (int y = yPos - 1; y >= 0; y--) {
            if (number == SudokuBoard[xPos][y]) {
                return true;
            }
        }
        return false;
    }

    private boolean isRegionConflict(final int[][] SudokuBoard, final int xPos, final int yPos, final int number) {
        int sizeM = SudokuGenerator.sizeM / 3;
        int xRegion = xPos / sizeM;
        int yRegion = yPos / sizeM;

        for (int x = xRegion * sizeM; x < xRegion * sizeM + sizeM; x++) {
            for (int y = yRegion * sizeM; y < yRegion * sizeM + sizeM; y++) {
                if ((x != xPos || y != yPos) && number == SudokuBoard[x][y]) {
                    return true;
                }
            }
        }
        return false;
    }
}