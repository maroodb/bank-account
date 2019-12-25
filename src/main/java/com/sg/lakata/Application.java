/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata;

import com.sg.lakata.domain.Account;
import static com.sg.lakata.domain.Amount.amountOf;
import com.sg.lakata.exceptions.InsufficientFundsException;
import com.sg.lakata.exceptions.NegativeAmountException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maroodb
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        try {
            Account myAccount = new Account();
            
            myAccount.deposit(amountOf(1000.36));
            myAccount.withdraw(amountOf(500.26));
             myAccount.withdraw(amountOf(100.1));
            
            myAccount.printStatement(System.out);
        } catch (NegativeAmountException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InsufficientFundsException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
}
