package com.example.demo.entity;

public class Rows {

    private Cell[][] cells;

    public Rows() {
    }

    public Rows(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getRows() {
        return cells;
    }

    public void setRows(Cell[][] cells) {
        this.cells = cells;
    }
}
