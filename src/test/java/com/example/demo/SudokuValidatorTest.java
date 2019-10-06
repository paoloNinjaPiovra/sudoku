package com.example.demo;

import com.example.demo.entity.Cell;
import com.example.demo.excepions.SudokuException;
import com.example.demo.entity.Sudoku;
import com.example.demo.util.SudokuGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SudokuValidatorTest {

    @Test
    public void validate() throws SudokuException {
        int count0 = 0;
        int countNot0 = 0;
        int count = 0;
        int countKo = 0;

        Cell[][] validatedRows = new SudokuGenerator().fillValues();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Assert.assertTrue(validatedRows[row][col].getStatus() == 0);
                if (validatedRows[row][col].getStatus() == 0) {
                    count++;
                } else {
                    countKo++;
                }
                if (validatedRows[row][col].getValue() == 0) {
                    count0++;
                } else {
                    countNot0++;
                }
            }
        }
        Assert.assertTrue(count0 == 33);
        Assert.assertTrue(countNot0 == 48);
        Assert.assertTrue(count == 81);
        Assert.assertTrue(countKo == 0);
    }

    @Test
    public void validateKoRow0Column0Column8Subsection00Subsection06() throws SudokuException {

        Cell[][] rows = new Cell[][]{
                {new Cell("00", 0, 0), new Cell("01", 8, 0), new Cell("02", 1, 0), new Cell("03", 2, 0), new Cell("04", 4, 0), new Cell("05", 5, 0), new Cell("06", 6, 0), new Cell("07", 9, 0), new Cell("08", 0, 0)},
                {new Cell("10", 4, 0), new Cell("11", 7, 0), new Cell("12", 6, 0), new Cell("13", 1, 0), new Cell("14", 9, 0), new Cell("15", 3, 0), new Cell("16", 2, 0), new Cell("17", 8, 0), new Cell("18", 5, 0)},
                {new Cell("20", 5, 0), new Cell("21", 2, 0), new Cell("22", 9, 0), new Cell("23", 7, 0), new Cell("24", 6, 0), new Cell("25", 8, 0), new Cell("26", 1, 0), new Cell("27", 4, 0), new Cell("28", 3, 0)},
                {new Cell("30", 1, 0), new Cell("31", 5, 0), new Cell("32", 7, 0), new Cell("33", 6, 0), new Cell("34", 3, 0), new Cell("35", 4, 0), new Cell("36", 8, 0), new Cell("37", 2, 0), new Cell("38", 9, 0)},
                {new Cell("40", 9, 0), new Cell("41", 3, 0), new Cell("42", 4, 0), new Cell("43", 8, 0), new Cell("44", 1, 0), new Cell("45", 2, 0), new Cell("46", 7, 0), new Cell("47", 5, 0), new Cell("48", 6, 0)},
                {new Cell("50", 2, 0), new Cell("51", 6, 0), new Cell("52", 8, 0), new Cell("53", 5, 0), new Cell("54", 7, 0), new Cell("55", 9, 0), new Cell("56", 4, 0), new Cell("57", 3, 0), new Cell("58", 1, 0)},
                {new Cell("60", 6, 0), new Cell("61", 4, 0), new Cell("62", 3, 0), new Cell("63", 9, 0), new Cell("64", 2, 0), new Cell("65", 7, 0), new Cell("66", 5, 0), new Cell("67", 1, 0), new Cell("68", 8, 0)},
                {new Cell("70", 8, 0), new Cell("71", 1, 0), new Cell("72", 2, 0), new Cell("73", 3, 0), new Cell("74", 5, 0), new Cell("75", 6, 0), new Cell("76", 9, 0), new Cell("77", 7, 0), new Cell("78", 4, 0)},
                {new Cell("80", 7, 0), new Cell("81", 9, 0), new Cell("82", 5, 0), new Cell("83", 4, 0), new Cell("84", 8, 0), new Cell("85", 1, 0), new Cell("86", 3, 0), new Cell("87", 6, 0), new Cell("88", 2, 0)}
        };

        int count0 = 0;
        int countNot0 = 0;
        int count = 0;
        int countKo = 0;
        Sudoku sudoku = new Sudoku();
        Cell[][] validatedRows = sudoku.getSudoku(rows);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (validatedRows[row][col].getStatus() == 0) {
                    count++;
                } else {
                    countKo++;
                }
                if (validatedRows[row][col].getValue() == 0) {
                    count0++;
                } else {
                    countNot0++;
                }
            }
        }
        Assert.assertTrue(count0 == 2);
        Assert.assertTrue(countNot0 == 79);
        Assert.assertTrue(count == 48);
        Assert.assertTrue(countKo == 33);
    }

    @Test
    public void validateKoRow0Column0Subsection00() throws SudokuException {

        Cell[][] rows = new Cell[][] {
                {new Cell("00", 0, 0), new Cell("01", 8, 0), new Cell("02", 1, 0), new Cell("03", 2, 0), new Cell("04", 4, 0), new Cell("05", 5, 0), new Cell("06", 6, 0), new Cell("07", 9, 0), new Cell("08", 7, 0)},
                {new Cell("10", 4, 0), new Cell("11", 7, 0), new Cell("12", 6, 0), new Cell("13", 1, 0), new Cell("14", 9, 0), new Cell("15", 3, 0), new Cell("16", 2, 0), new Cell("17", 8, 0), new Cell("18", 5, 0)},
                {new Cell("20", 5, 0), new Cell("21", 2, 0), new Cell("22", 9, 0), new Cell("23", 7, 0), new Cell("24", 6, 0), new Cell("25", 8, 0), new Cell("26", 1, 0), new Cell("27", 4, 0), new Cell("28", 3, 0)},
                {new Cell("30", 1, 0), new Cell("31", 5, 0), new Cell("32", 7, 0), new Cell("33", 6, 0), new Cell("34", 3, 0), new Cell("35", 4, 0), new Cell("36", 8, 0), new Cell("37", 2, 0), new Cell("38", 9, 0)},
                {new Cell("40", 9, 0), new Cell("41", 3, 0), new Cell("42", 4, 0), new Cell("43", 8, 0), new Cell("44", 1, 0), new Cell("45", 2, 0), new Cell("46", 7, 0), new Cell("47", 5, 0), new Cell("48", 6, 0)},
                {new Cell("50", 2, 0), new Cell("51", 6, 0), new Cell("52", 8, 0), new Cell("53", 5, 0), new Cell("54", 7, 0), new Cell("55", 9, 0), new Cell("56", 4, 0), new Cell("57", 3, 0), new Cell("58", 1, 0)},
                {new Cell("60", 6, 0), new Cell("61", 4, 0), new Cell("62", 3, 0), new Cell("63", 9, 0), new Cell("64", 2, 0), new Cell("65", 7, 0), new Cell("66", 5, 0), new Cell("67", 1, 0), new Cell("68", 8, 0)},
                {new Cell("70", 8, 0), new Cell("71", 1, 0), new Cell("72", 2, 0), new Cell("73", 3, 0), new Cell("74", 5, 0), new Cell("75", 6, 0), new Cell("76", 9, 0), new Cell("77", 7, 0), new Cell("78", 4, 0)},
                {new Cell("80", 7, 0), new Cell("81", 9, 0), new Cell("82", 5, 0), new Cell("83", 4, 0), new Cell("84", 8, 0), new Cell("85", 1, 0), new Cell("86", 3, 0), new Cell("87", 6, 0), new Cell("88", 2, 0)}
        };

        int count0 = 0;
        int countNot0 = 0;
        int count = 0;
        int countKo = 0;
        Sudoku sudoku = new Sudoku();
        Cell[][] validatedRows = sudoku.getSudoku(rows);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (validatedRows[row][col].getStatus() == 0) {
                    count++;
                } else {
                    countKo++;
                }
                if (validatedRows[row][col].getValue() == 0) {
                    count0++;
                } else {
                    countNot0++;
                }
            }
        }
        Assert.assertTrue(count0 == 1);
        Assert.assertTrue(countNot0 == 80);
        Assert.assertTrue(count == 60);
        Assert.assertTrue(countKo == 21);
    }
}
