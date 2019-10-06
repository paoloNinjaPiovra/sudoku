package com.example.demo.util;

import com.example.demo.excepions.SudokuException;
import com.example.demo.entity.Cell;

import java.util.stream.IntStream;

public class SudokuValidator {

    private static int BOARD_SIZE = 9;
    private static int SUBSECTION_SIZE = 3;
    private static int NO_VALUE = 0;
    private static int BOARD_START_INDEX = 0;
    private static final int SIZE = 9;

    public static boolean rowConstraint(Cell[][] board, int row) throws SudokuException {
        try {
            boolean[] constraint = new boolean[BOARD_SIZE];
            return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
                    .allMatch(column -> checkConstraint(board, row, constraint, column));
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    public static boolean columnConstraint(Cell[][] board, int column) throws SudokuException {
        try {
            boolean[] constraint = new boolean[BOARD_SIZE];
            return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
                    .allMatch(row -> checkConstraint(board, row, constraint, column));
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    public static boolean subsectionConstraint(Cell[][] board, int row, int column) throws SudokuException {
        try {
            boolean[] constraint = new boolean[SIZE];
            int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
            int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

            int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
            int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

            for (int r = subsectionRowStart; r < subsectionRowEnd; r++)
                for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++)
                    if (!checkConstraint(board, r, constraint, c))
                        return false;
            return true;
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    private static boolean checkConstraint(Cell[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column].getValue() != NO_VALUE)
            if (!constraint[board[row][column].getValue() - 1])
                constraint[board[row][column].getValue() - 1] = true;
            else
                return false;
        else
            return false;
        return true;
    }
}
