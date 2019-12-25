/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain.test;

import com.sg.lakata.domain.Account;
import com.sg.lakata.domain.Amount;
import static com.sg.lakata.domain.Amount.amountOf;
import com.sg.lakata.exceptions.InsufficientFundsException;
import com.sg.lakata.exceptions.NegativeAmountException;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author maroodb
 */
public class AccountTest {

    private Account account;

    @Before
    public void initialise() {
        this.account = new Account();
    }

    @Test(expected = NegativeAmountException.class)
    public void should_detect_negative_value_deposit() throws NegativeAmountException {
        Amount depositAmount = amountOf(-12.55);
        this.account.deposit(depositAmount);
    }

    @Test(expected = NegativeAmountException.class)
    public void should_detect_zero_value_deposit() throws NegativeAmountException {
        Amount depositAmount = amountOf(0);
        this.account.deposit(depositAmount);
    }

    @Test(expected = NegativeAmountException.class)
    public void should_detect_negative_value_withdraw() throws NegativeAmountException, InsufficientFundsException {
        Amount withdrawAmount = amountOf(-12.55);
        this.account.withdraw(withdrawAmount);
    }

    @Test(expected = NegativeAmountException.class)
    public void should_detect_zero_value_withdraw() throws NegativeAmountException, InsufficientFundsException {
        Amount withdrawAmount = amountOf(0);
        this.account.withdraw(withdrawAmount);
    }

    @Test(expected = InsufficientFundsException.class)
    public void should_detect_insufficient_funds_withdraw() throws InsufficientFundsException, NegativeAmountException {
        Amount withdrawAmount = amountOf(1200);
        this.account.withdraw(withdrawAmount);
    }
    
    public void should_increase_balance_after_deposit() throws NegativeAmountException {
        this.account = new Account(amountOf(900));
        Amount depositAmount = amountOf(100);
        this.account.deposit(depositAmount);
        assertThat(this.account.getBalance(), is(equalTo(amountOf(1000))));
       
    }
    
    public void should_decrease_balance_after_withdraw() throws InsufficientFundsException, NegativeAmountException{
        this.account = new Account(amountOf(1000));
        Amount withdrawAmount = amountOf(100);
        this.account.withdraw(withdrawAmount);
        assertThat(this.account.getBalance(), is(equalTo(amountOf(900))));
    }

}
