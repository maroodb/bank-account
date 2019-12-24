/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain;

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
    }
    
    
    public void deposit(Amount amount) {
        
    }
    public void withdraw(Amount amount) {
        
    }
    public void printStatement(PrintStream printer) {
        
    }
    public Amount getBalance() {
        return balance;
    }
    
    private void sendTransaction(Amount amount) {
        
    }
    
   
    
    
}
