package com.example.demo.entity;

import com.example.demo.excepions.SudokuException;
import com.example.demo.entity.Cell;
import com.example.demo.entity.Coordinates;
import com.example.demo.util.SudokuValidator;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private static final int SIZE = 9;
    private static int SUBSECTION_SIZE = 3;

    private List<Integer> row = new ArrayList<>();
    private List<Integer> column = new ArrayList<>();
    private List<Coordinates> subsection = new ArrayList<>();

    public Sudoku() {
    }

    public Cell[][] getSudoku(Cell[][] board) throws SudokuException {
        checkRow(board, row);
        updateRowState(board, row);

        checkColumn(board, column);
        updateColumnState(board, column);

        checkSubSection(board, subsection);
        updateSubSectionState(board, subsection);
        return board;
    }

    private void checkRow(Cell[][] board, List<Integer> rowList) throws SudokuException {
        try {
            Boolean rowStatus;
            for (int row = 0; row < 9; row++) {
                rowStatus = SudokuValidator.rowConstraint(board, row);
                if (!rowStatus || null == rowStatus) {
                    rowList.add(row);
                }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    private void updateRowState(Cell[][] board, List<Integer> row) throws SudokuException {
        try {
            if (!row.isEmpty()) {
                for (Integer rowIndex : row) {
                    for (int col = 0; col < SIZE; col++) {
                        board[rowIndex][col] = new Cell(board[rowIndex][col].getId(), board[rowIndex][col].getValue(), 1);
                    }
                }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    private void checkColumn(Cell[][] board, List<Integer> columnList) throws SudokuException {
        try {
            Boolean columnStatus;
            for (int col = 0; col < 9; col++) {
                columnStatus = SudokuValidator.columnConstraint(board, col);
                if (!columnStatus || null == columnStatus) {
                    columnList.add(col);
                }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    private void updateColumnState(Cell[][] board, List<Integer> column) throws SudokuException {
        try {
            if (!column.isEmpty()) {
                for (Integer columnIndex : column) {
                    for (int row = 0; row < SIZE; row++) {
                        board[row][columnIndex] = new Cell(board[row][columnIndex].getId(), board[row][columnIndex].getValue(), 1);
                    }
                }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    private void checkSubSection(Cell[][] board, List<Coordinates> subsection) throws SudokuException {
        try {
            Boolean subsectionStatus;
            for (int row = 0; row < SIZE; row = row + SUBSECTION_SIZE) {
                for (int col = 0; col < SIZE; col = col + SUBSECTION_SIZE) {
                    subsectionStatus = SudokuValidator.subsectionConstraint(board, row, col);
                    if (!subsectionStatus || null == subsectionStatus) {
                        subsection.add(new Coordinates(row, col));
                    }
                }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }

    private void updateSubSectionState(Cell[][] board, List<Coordinates> subsection) throws SudokuException {
        try {
            if (!subsection.isEmpty()) {
                for (Coordinates coordinate : subsection) {
                    for (int row = coordinate.getX(); row < coordinate.getX() + SUBSECTION_SIZE; row++) {
                        for (int col = coordinate.getY(); col < coordinate.getY() + SUBSECTION_SIZE; col++) {
                            board[row][col] = new Cell(board[row][col].getId(), board[row][col].getValue(), 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new SudokuException(e.getMessage());
        }
    }
}
