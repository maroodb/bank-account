/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain;

import static com.sg.lakata.commons.Formatter.LINE_FORMAT;
import java.io.PrintStream;

/**
 *
 * @author maroodb
 */
public class Record {
    
    private Transaction transaction;
    private Amount currentBalance;

    public Record(Transaction transaction, Amount currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }
    
    public void printTo(PrintStream printer) {
      
        this.transaction.printTo(printer, this.currentBalance);
    }

   
    
    
}
