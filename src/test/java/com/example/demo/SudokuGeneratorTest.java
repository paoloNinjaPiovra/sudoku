package com.example.demo;

import com.example.demo.entity.Cell;
import com.example.demo.excepions.SudokuException;
import com.example.demo.util.SudokuGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SudokuGeneratorTest {

    private static final int SIZE = 9;

    private Cell[][] rowsResult;

    @Test
    public void generateSudoku() throws SudokuException {
        int count = 0;

        SudokuGenerator sudokuGenerator = new SudokuGenerator();
        rowsResult = sudokuGenerator.fillValues();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Assert.assertTrue(rowsResult[row][col] instanceof Cell);
                Assert.assertTrue(null != rowsResult[row][col].getId()  && "" != rowsResult[row][col].getId().trim());
                Assert.assertTrue(rowsResult[row][col].getStatus() == 0);
                Assert.assertTrue(rowsResult[row][col].getValue() <= SIZE && rowsResult[row][col].getValue() >= 0);
                if (rowsResult[row][col].getValue() == 0)
                    count++;
            }
        }
        Assert.assertTrue(count > 0);
        Assert.assertTrue(count == 33);
    }
}
