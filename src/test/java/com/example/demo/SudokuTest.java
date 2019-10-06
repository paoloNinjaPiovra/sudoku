package com.example.demo;

import com.example.demo.entity.Cell;
import com.example.demo.excepions.SudokuException;
import com.example.demo.entity.Sudoku;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SudokuTest {

    private static final int SIZE = 9; // size of our Sudoku grids
    private static int SUBSECTION_SIZE = 3;

    private int count = 0;
    private int countKo = 0;
    private Cell[][] rows;
    private Cell[][] rowsResult;

    @Test
    public void getSudokuColumn0Ko() throws SudokuException {
        count = 0;
        rows = new Cell[][] {
            {new Cell("00", 0, 0), new Cell("01", 1, 0), new Cell("02", 5, 0), new Cell("03", 2, 0), new Cell("04", 3, 0), new Cell("05", 4, 0), new Cell("06", 7, 0), new Cell("07", 8, 0), new Cell("08", 6, 0)},
            {new Cell("10", 4, 0), new Cell("11", 8, 0), new Cell("12", 3, 0), new Cell("13", 1, 0), new Cell("14", 6, 0), new Cell("15", 7, 0), new Cell("16", 9, 0), new Cell("17", 5, 0), new Cell("18", 2, 0)},
            {new Cell("20", 7, 0), new Cell("21", 2, 0), new Cell("22", 6, 0), new Cell("23", 8, 0), new Cell("24", 5, 0), new Cell("25", 9, 0), new Cell("26", 1, 0), new Cell("27", 3, 0), new Cell("28", 4, 0)},
            {new Cell("30", 1, 0), new Cell("31", 9, 0), new Cell("32", 4, 0), new Cell("33", 5, 0), new Cell("34", 2, 0), new Cell("35", 8, 0), new Cell("36", 6, 0), new Cell("37", 7, 0), new Cell("38", 3, 0)},
            {new Cell("40", 3, 0), new Cell("41", 7, 0), new Cell("42", 2, 0), new Cell("43", 6, 0), new Cell("44", 9, 0), new Cell("45", 1, 0), new Cell("46", 8, 0), new Cell("47", 4, 0), new Cell("48", 5, 0)},
            {new Cell("50", 5, 0), new Cell("51", 6, 0), new Cell("52", 8, 0), new Cell("53", 7, 0), new Cell("54", 4, 0), new Cell("55", 6, 0), new Cell("56", 2, 0), new Cell("57", 1, 0), new Cell("58", 9, 0)},
            {new Cell("60", 8, 0), new Cell("61", 5, 0), new Cell("62", 9, 0), new Cell("63", 3, 0), new Cell("64", 1, 0), new Cell("65", 8, 0), new Cell("66", 4, 0), new Cell("67", 2, 0), new Cell("68", 7, 0)},
            {new Cell("70", 6, 0), new Cell("71", 3, 0), new Cell("72", 1, 0), new Cell("73", 4, 0), new Cell("74", 7, 0), new Cell("75", 2, 0), new Cell("76", 5, 0), new Cell("77", 9, 0), new Cell("78", 8, 0)},
            {new Cell("80", 2, 0), new Cell("81", 4, 0), new Cell("82", 7, 0), new Cell("83", 9, 0), new Cell("84", 8, 0), new Cell("85", 4, 0), new Cell("86", 3, 0), new Cell("87", 6, 0), new Cell("88", 1, 0)}
        };

        Sudoku sudoku = new Sudoku();
        rowsResult = sudoku.getSudoku(rows);
        for (int col = 0; col < SIZE; col++) {
            Assert.assertTrue(rowsResult[0][col].getStatus() == 1);
            if (rowsResult[0][col].getStatus() == 1) {
                count++;
            }
        }
        Assert.assertTrue(count == 9);

        count = 0;
        for (int row = 1; row < SIZE; row++) {
            for (int col = 1; col < SIZE; col++) {
                Assert.assertTrue(rows[row][col].getValue() == rowsResult[row][col].getValue() && rows[row][col].getStatus() == rowsResult[row][col].getStatus());
                if (rows[row][col].getStatus() == rowsResult[row][col].getStatus()) {
                    count++;
                }
            }
        }
        Assert.assertTrue(count == 64);
    }

    @Test
    public void getSudokuRow0Ko() throws SudokuException {
        count = 0;
        rows = new Cell[][] {
            {new Cell("00", 0, 0), new Cell("01", 1, 0), new Cell("02", 5, 0), new Cell("03", 2, 0), new Cell("04", 3, 0), new Cell("05", 4, 0), new Cell("06", 7, 0), new Cell("07", 8, 0), new Cell("08", 6, 0)},
            {new Cell("10", 4, 0), new Cell("11", 8, 0), new Cell("12", 3, 0), new Cell("13", 1, 0), new Cell("14", 6, 0), new Cell("15", 7, 0), new Cell("16", 9, 0), new Cell("17", 5, 0), new Cell("18", 2, 0)},
            {new Cell("20", 7, 0), new Cell("21", 2, 0), new Cell("22", 6, 0), new Cell("23", 8, 0), new Cell("24", 5, 0), new Cell("25", 9, 0), new Cell("26", 1, 0), new Cell("27", 3, 0), new Cell("28", 4, 0)},
            {new Cell("30", 1, 0), new Cell("31", 9, 0), new Cell("32", 4, 0), new Cell("33", 5, 0), new Cell("34", 2, 0), new Cell("35", 8, 0), new Cell("36", 6, 0), new Cell("37", 7, 0), new Cell("38", 3, 0)},
            {new Cell("40", 3, 0), new Cell("41", 7, 0), new Cell("42", 2, 0), new Cell("43", 6, 0), new Cell("44", 9, 0), new Cell("45", 1, 0), new Cell("46", 8, 0), new Cell("47", 4, 0), new Cell("48", 5, 0)},
            {new Cell("50", 5, 0), new Cell("51", 6, 0), new Cell("52", 8, 0), new Cell("53", 7, 0), new Cell("54", 4, 0), new Cell("55", 6, 0), new Cell("56", 2, 0), new Cell("57", 1, 0), new Cell("58", 9, 0)},
            {new Cell("60", 8, 0), new Cell("61", 5, 0), new Cell("62", 9, 0), new Cell("63", 3, 0), new Cell("64", 1, 0), new Cell("65", 8, 0), new Cell("66", 4, 0), new Cell("67", 2, 0), new Cell("68", 7, 0)},
            {new Cell("70", 6, 0), new Cell("71", 3, 0), new Cell("72", 1, 0), new Cell("73", 4, 0), new Cell("74", 7, 0), new Cell("75", 2, 0), new Cell("76", 5, 0), new Cell("77", 9, 0), new Cell("78", 8, 0)},
            {new Cell("80", 2, 0), new Cell("81", 4, 0), new Cell("82", 7, 0), new Cell("83", 9, 0), new Cell("84", 8, 0), new Cell("85", 4, 0), new Cell("86", 3, 0), new Cell("87", 6, 0), new Cell("88", 1, 0)}
        };

        Sudoku sudoku = new Sudoku();
        rowsResult = sudoku.getSudoku(rows);

        for (int row = 0; row < SIZE; row++) {
            Assert.assertTrue(rowsResult[row][0].getStatus() == 1);
            if (rowsResult[row][0].getStatus() == 1) {
                count++;
            }
        }
        Assert.assertTrue(count == 9);

        count = 0;
        for (int row = 1; row < SIZE; row++) {
            for (int col = 1; col < SIZE; col++) {
                Assert.assertTrue(rows[row][col].getValue() == rowsResult[row][col].getValue() && rows[row][col].getStatus() == rowsResult[row][col].getStatus());
                if (rows[row][col].getStatus() == rowsResult[row][col].getStatus()) {
                    count++;
                }
            }
        }
        Assert.assertTrue(count == 64);
    }

    @Test
    public void getSudokuSubsection33Ko() throws SudokuException {
        count = 0;
        countKo = 0;
        rows = new Cell[][] {
            {new Cell("00", 3, 0), new Cell("01", 8, 0), new Cell("02", 1, 0), new Cell("03", 2, 0), new Cell("04", 4, 0), new Cell("05", 5, 0), new Cell("06", 6, 0), new Cell("07", 9, 0), new Cell("08", 7, 0)},
            {new Cell("10", 4, 0), new Cell("11", 7, 0), new Cell("12", 6, 0), new Cell("13", 1, 0), new Cell("14", 9, 0), new Cell("15", 3, 0), new Cell("16", 2, 0), new Cell("17", 8, 0), new Cell("18", 5, 0)},
            {new Cell("20", 5, 0), new Cell("21", 2, 0), new Cell("22", 9, 0), new Cell("23", 7, 0), new Cell("24", 6, 0), new Cell("25", 8, 0), new Cell("26", 1, 0), new Cell("27", 4, 0), new Cell("28", 3, 0)},
            {new Cell("30", 1, 0), new Cell("31", 5, 0), new Cell("32", 7, 0), new Cell("33", 0, 0), new Cell("34", 3, 0), new Cell("35", 4, 0), new Cell("36", 8, 0), new Cell("37", 2, 0), new Cell("38", 9, 0)},
            {new Cell("40", 9, 0), new Cell("41", 3, 0), new Cell("42", 4, 0), new Cell("43", 8, 0), new Cell("44", 1, 0), new Cell("45", 2, 0), new Cell("46", 7, 0), new Cell("47", 5, 0), new Cell("48", 6, 0)},
            {new Cell("50", 2, 0), new Cell("51", 6, 0), new Cell("52", 8, 0), new Cell("53", 5, 0), new Cell("54", 7, 0), new Cell("55", 9, 0), new Cell("56", 4, 0), new Cell("57", 3, 0), new Cell("58", 1, 0)},
            {new Cell("60", 6, 0), new Cell("61", 4, 0), new Cell("62", 3, 0), new Cell("63", 9, 0), new Cell("64", 2, 0), new Cell("65", 7, 0), new Cell("66", 5, 0), new Cell("67", 1, 0), new Cell("68", 8, 0)},
            {new Cell("70", 8, 0), new Cell("71", 1, 0), new Cell("72", 2, 0), new Cell("73", 3, 0), new Cell("74", 5, 0), new Cell("75", 6, 0), new Cell("76", 9, 0), new Cell("77", 7, 0), new Cell("78", 4, 0)},
            {new Cell("80", 7, 0), new Cell("81", 9, 0), new Cell("82", 5, 0), new Cell("83", 4, 0), new Cell("84", 8, 0), new Cell("85", 1, 0), new Cell("86", 3, 0), new Cell("87", 6, 0), new Cell("88", 2, 0)}
        };

        Sudoku sudoku = new Sudoku();
        rowsResult = sudoku.getSudoku(rows);
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Assert.assertTrue(rows[row][col].getValue() == rowsResult[row][col].getValue() && rows[row][col].getStatus() == rowsResult[row][col].getStatus());
                System.out.print(" " + rowsResult[row][col].getStatus());
                if (rowsResult[row][col].getStatus() == 1) {
                    countKo++;
                } else {
                    count++;
                }
            }
            System.out.println();
        }
        Assert.assertTrue(countKo == 21);
        Assert.assertTrue(count == 60);
        Assert.assertTrue(rowsResult[3][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[3][4].getStatus() == 1);
        Assert.assertTrue(rowsResult[3][5].getStatus() == 1);
        Assert.assertTrue(rowsResult[4][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[4][4].getStatus() == 1);
        Assert.assertTrue(rowsResult[4][5].getStatus() == 1);
        Assert.assertTrue(rowsResult[5][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[5][4].getStatus() == 1);
        Assert.assertTrue(rowsResult[5][5].getStatus() == 1);

        Assert.assertTrue(rowsResult[0][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[1][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[2][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[6][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[7][3].getStatus() == 1);
        Assert.assertTrue(rowsResult[8][3].getStatus() == 1);

        Assert.assertTrue(rowsResult[3][0].getStatus() == 1);
        Assert.assertTrue(rowsResult[3][1].getStatus() == 1);
        Assert.assertTrue(rowsResult[3][2].getStatus() == 1);
        Assert.assertTrue(rowsResult[3][6].getStatus() == 1);
        Assert.assertTrue(rowsResult[3][7].getStatus() == 1);
        Assert.assertTrue(rowsResult[3][8].getStatus() == 1);

        Assert.assertTrue(rowsResult[0][0].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][0].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][0].getStatus() == 0);

        Assert.assertTrue(rowsResult[0][1].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][1].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][1].getStatus() == 0);

        Assert.assertTrue(rowsResult[0][2].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][2].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][2].getStatus() == 0);

        Assert.assertTrue(rowsResult[0][6].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][6].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][6].getStatus() == 0);

        Assert.assertTrue(rowsResult[0][7].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][7].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][7].getStatus() == 0);

        Assert.assertTrue(rowsResult[0][8].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][8].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][8].getStatus() == 0);

        Assert.assertTrue(rowsResult[0][4].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][4].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][4].getStatus() == 0);

        Assert.assertTrue(rowsResult[0][5].getStatus() == 0);
        Assert.assertTrue(rowsResult[1][5].getStatus() == 0);
        Assert.assertTrue(rowsResult[2][5].getStatus() == 0);

        Assert.assertTrue(rowsResult[4][0].getStatus() == 0);
        Assert.assertTrue(rowsResult[5][0].getStatus() == 0);

        Assert.assertTrue(rowsResult[4][1].getStatus() == 0);
        Assert.assertTrue(rowsResult[5][1].getStatus() == 0);

        Assert.assertTrue(rowsResult[4][2].getStatus() == 0);
        Assert.assertTrue(rowsResult[5][2].getStatus() == 0);

        Assert.assertTrue(rowsResult[4][6].getStatus() == 0);
        Assert.assertTrue(rowsResult[5][6].getStatus() == 0);

        Assert.assertTrue(rowsResult[4][7].getStatus() == 0);
        Assert.assertTrue(rowsResult[5][7].getStatus() == 0);

        Assert.assertTrue(rowsResult[4][8].getStatus() == 0);
        Assert.assertTrue(rowsResult[5][8].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][0].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][0].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][0].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][1].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][1].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][1].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][2].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][2].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][2].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][6].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][6].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][6].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][7].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][7].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][7].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][8].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][8].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][8].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][4].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][4].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][4].getStatus() == 0);

        Assert.assertTrue(rowsResult[6][5].getStatus() == 0);
        Assert.assertTrue(rowsResult[7][5].getStatus() == 0);
        Assert.assertTrue(rowsResult[8][5].getStatus() == 0);

    }
}
