package com.example.demo.controller;

import com.example.demo.excepions.SudokuException;
import com.example.demo.entity.Rows;
import com.example.demo.entity.Sudoku;
import com.example.demo.util.SudokuGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SudokuController {

    @GetMapping(path="/")
    public ResponseEntity<Rows> create() {
        ResponseEntity responseEntity;
        try {
            Rows rows = new Rows(new SudokuGenerator().fillValues());
            responseEntity = new ResponseEntity(rows, null, HttpStatus.OK);
            return responseEntity;
        } catch (SudokuException e) {
            responseEntity = new ResponseEntity(null, null, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }

    }

    @PostMapping(path="/", consumes = "application/json", produces = "application/json")
    public ResponseEntity validate(@RequestBody Rows rows) {
        ResponseEntity responseEntity;
        try {
            rows.setRows(new Sudoku().getSudoku(rows.getRows()));
            responseEntity = new ResponseEntity(rows, null, HttpStatus.OK);
            return responseEntity;
        } catch (SudokuException e) {
            responseEntity = new ResponseEntity(null, null, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }
}
