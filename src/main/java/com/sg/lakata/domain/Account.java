/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain;

import static com.sg.lakata.domain.Amount.amountOf;
import com.sg.lakata.exceptions.InsufficientFundsException;
import com.sg.lakata.exceptions.NegativeAmountException;
import java.io.PrintStream;

/**
 *
 * @author maroodb
 */
public class Account {

    private Amount balance;
    private Statement statement;

    public Account() {
        this.statement = new Statement();
        this.balance = amountOf(0);
    }

    public Account(Amount balance) {
        this.balance = balance;
    }

    public Account(Statement statement) {
        this.statement = statement;
    }

    public Account(Amount balance, Statement statement) {
        this.balance = balance;
        this.statement = statement;
    }
    
    
    
    public void deposit(Amount amount) throws NegativeAmountException {

        if (amount.isStrictlyPositive()) {
            this.doTransaction(amount);
        } else {
            throw new NegativeAmountException("Deposit amount must be strictly positive");
        }

    }

    public void withdraw(Amount amount) throws InsufficientFundsException, NegativeAmountException  {
        if (amount.isStrictlyPositive()) {
            if (this.balance.isGreaterOrEqualThan(amount)) {
                this.doTransaction(amount.negative());
            } else {
                throw new InsufficientFundsException();
            }
        } else {
            throw new NegativeAmountException("Withdraw amount must be strictly positive");
        }

    }

    public void printStatement(PrintStream printer) {
        this.statement.printTo(printer);
    }

    public Amount getBalance() {
        return this.balance;
    }

    private void doTransaction(Amount amount) {
        Transaction transaction = new Transaction(amount);
        this.balance = transaction.getBalanceAfterTransaction(this.balance);
        Record record = new Record(transaction, this.balance);
        this.statement.addRecord(record);
    }

}
