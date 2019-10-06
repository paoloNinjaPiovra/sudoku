package com.example.demo.util;

import com.example.demo.excepions.SudokuException;
import com.example.demo.entity.Cell;

public class SudokuGenerator {

    private static int[] mat[];
    private static int N = 9; // number of columns/rows.
    private static int SRN; // square root of N
    private static int K = 33; // No. Of missing digits

    // Constructor
    public SudokuGenerator() {
        // Compute square root of N
        Double SRNd = Math.sqrt(N);
        SRN = SRNd.intValue();
        mat = new int[N][N];
    }

    // Sudoku Generator
    public Cell[][] fillValues() throws SudokuException {
        try {
            // Fill the diagonal of SRN x SRN matrices
            fillDiagonal();
            // Fill remaining blocks
            fillRemaining(0, SRN);
            // Remove Randomly K digits to make game
            removeKDigits();
            return transformToCell(mat);
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // Fill the diagonal SRN number of SRN x SRN matrices
    private void fillDiagonal() throws SudokuException {
        try {
            for (int i = 0; i < N; i = i + SRN)
                // for diagonal box, start coordinates->i==j
                fillBox(i, i);
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // Returns false if given 3 x 3 block contains num.
    private boolean unUsedInBox(int rowStart, int colStart, int num) throws SudokuException {
        try {
            for (int row = 0; row < SRN; row++)
                for (int col = 0; col < SRN; col++)
                    if (mat[rowStart + row][colStart + col] == num)
                        return false;
            return true;
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // Fill a 3 x 3 matrix.
    private void fillBox(int row, int col) throws SudokuException {
        try {
            int num;
            for (int i = 0; i < SRN; i++) {
                for (int j = 0; j < SRN; j++) {
                    do {
                        num = randomGenerator(N);
                    }
                    while (!unUsedInBox(row, col, num));
                    mat[row + i][col + j] = num;
                }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // Random generator
    private int randomGenerator(int num) throws SudokuException {
        try {
            return (int) Math.floor((Math.random() * num + 1));
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // Check if safe to put in cell
    private boolean CheckIfSafe(int i, int j, int num) throws SudokuException {
        try {
            return (unUsedInRow(i, num) &&
                    unUsedInCol(j, num) &&
                    unUsedInBox(i - i % SRN, j - j % SRN, num));
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // check in the row for existence
    private boolean unUsedInRow(int i, int num) throws SudokuException {
        try {
            for (int j = 0; j < N; j++)
                if (mat[i][j] == num)
                    return false;
            return true;
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // check in the row for existence
    private boolean unUsedInCol(int j, int num) throws SudokuException {
        try {
            for (int i = 0; i < N; i++)
                if (mat[i][j] == num)
                    return false;
            return true;
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // A recursive function to fill remaining
    // matrix
    private boolean fillRemaining(int i, int j) throws SudokuException {
        try {
            if (j >= N && i < N - 1) {
                i = i + 1;
                j = 0;
            }
            if (i >= N && j >= N)
                return true;
            if (i < SRN) {
                if (j < SRN)
                    j = SRN;
            } else if (i < N - SRN) {
                if (j == (int) (i / SRN) * SRN)
                    j = j + SRN;
            } else {
                if (j == N - SRN) {
                    i = i + 1;
                    j = 0;
                    if (i >= N)
                        return true;
                }
            }
            for (int num = 1; num <= N; num++) {
                if (CheckIfSafe(i, j, num)) {
                    mat[i][j] = num;
                    if (fillRemaining(i, j + 1))
                        return true;
                    mat[i][j] = 0;
                }
            }
            return false;
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    // Remove the K no. of digits to
    // complete game
    private void removeKDigits() throws SudokuException {
        try {
            int cellId = 0;
            int count = K;
            while (count != 0) {
                cellId = randomGenerator(N * N);
                // extract coordinates i and j
                int i = (cellId / N);
                int j = cellId % 9;
                if (j != 0)
                    j = j - 1;
                if (i >= 0 && i < 9 && j >= 0 && j < 9 )
                    if (mat[i][j] != 0) {
                        count--;
                        mat[i][j] = 0;
                    }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    private Cell[][] transformToCell(int[][] result) throws SudokuException {
        try {
            Cell[][] solution = new Cell[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    solution[i][j] = new Cell(i + "" + j, result[i][j], 0);
                }
            }
            return solution;
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }
}

