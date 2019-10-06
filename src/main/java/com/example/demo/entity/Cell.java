package com.example.demo.entity;

public class Cell {
    private String id;
    private int value;
    private int status;

    public Cell(String id, int value, int status) {
        this.id = id;
        this.value = value;
        this.status = status;
    }

    public Cell() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
