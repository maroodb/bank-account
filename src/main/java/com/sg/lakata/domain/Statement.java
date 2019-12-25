/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain;

import static com.sg.lakata.commons.Formatter.LINE_FORMAT;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maroodb
 */
public class Statement {
    
    private List<Record> records;

    public Statement() {
        this.records = new ArrayList<>();
    }
    
    public void addRecord(Record record) {
        this.records.add(record);
    }
    
    public void printTo(PrintStream printer) {
        this.printHeaderTo(printer);
        this.records.forEach(record -> record.printTo(printer));
    }
    
     private void printHeaderTo(PrintStream printer) {
        String header = String.format(LINE_FORMAT, "DATE", "DEPOSIT", "WITHDRAW", "BALANCE");
        printer.println(header);
    }
    
}
