/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain.test;

import com.sg.lakata.domain.Amount;
import static com.sg.lakata.domain.Amount.amountOf;
import com.sg.lakata.domain.Transaction;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author maroodb
 */
public class TransactionTest {

    @Test
    public void
            should_calculate_current_balance_after_deposit() {
        Amount balance = amountOf(900);
        Transaction transaction = new Transaction(amountOf(100));
        Amount currentValue = transaction.getBalanceAfterTransaction(balance);
        assertThat(currentValue, is(amountOf(1000)));
    }

    @Test
    public void
            should_calculate_current_balance_after_withdraw() {
        Amount balance = amountOf(1000);
        Transaction transaction = new Transaction(amountOf(-100));
        Amount currentValue = transaction.getBalanceAfterTransaction(balance);
        assertThat(currentValue, is(amountOf(900)));
    }
}
