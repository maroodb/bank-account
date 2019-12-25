/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain;

import static com.sg.lakata.commons.Formatter.EMPTY_VALUE;
import static com.sg.lakata.commons.Formatter.LINE_FORMAT;
import com.sg.lakata.commons.LineEnum;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;

/**
 *
 * @author maroodb
 */
public class Transaction {

    private Amount amount;
    private LocalDateTime transactionTime;

    public Transaction(Amount amount) {
        this.transactionTime = LocalDateTime.now();
        this.amount = amount;
    }

    public Transaction(Amount amount, LocalDateTime transactionTime) {
        this.amount = amount;
        this.transactionTime = transactionTime;
    }
    
    

    public Amount getBalanceAfterTransaction(Amount balance) {
        return balance.plus(amount);
    }

    public void printTo(PrintStream printer, Amount currentBalance) {
        EnumMap<LineEnum, String> lineMap = new EnumMap<>(LineEnum.class);
        this.initLineMap(lineMap);
        this.addDateTo(lineMap);
        this.addValueTo(lineMap);
        this.addCurrentBalance(lineMap, currentBalance);
        
        String line = String.format(LINE_FORMAT,
                lineMap.get(LineEnum.DATE),
                lineMap.get(LineEnum.DEPOSIT),
                lineMap.get(LineEnum.WITHDRAW),
                lineMap.get(LineEnum.BALANCE));
        
        printer.println(line);

    }

    private void addDateTo(EnumMap lineMap) {
        lineMap.put(LineEnum.DATE, this.transactionTime.format(DateTimeFormatter.ISO_DATE));
       
    }

    private void addValueTo(EnumMap lineMap) {
        if (this.amount.isStrictlyPositive()) {
            this.addDeposit(lineMap);
        } else {
            this.addWithdraw(lineMap);
        }
    }

    private void addDeposit(EnumMap lineMap) {
        lineMap.put(LineEnum.DEPOSIT, this.amount.toString());      
    }

    private void addWithdraw(EnumMap lineMap) {
        lineMap.put(LineEnum.WITHDRAW, this.amount.toString());      
    }

    private void addCurrentBalance(EnumMap lineMap, Amount currentBalance) {
        lineMap.put(LineEnum.BALANCE, currentBalance.toString());
       
    }

    private void initLineMap(EnumMap<LineEnum, String> lineMap) {
        lineMap.put(LineEnum.DATE, EMPTY_VALUE);
        lineMap.put(LineEnum.DEPOSIT, EMPTY_VALUE);
        lineMap.put(LineEnum.WITHDRAW, EMPTY_VALUE);
        lineMap.put(LineEnum.BALANCE, EMPTY_VALUE);
    }

}
