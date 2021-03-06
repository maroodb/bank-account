/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain.test;

import static com.sg.lakata.commons.Formatter.LINE_FORMAT;
import static com.sg.lakata.domain.Amount.amountOf;
import com.sg.lakata.domain.Record;
import com.sg.lakata.domain.Statement;
import com.sg.lakata.domain.Transaction;
import java.io.PrintStream;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author maroodb
 */
@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    
    private Statement statement;
    @Mock
    private PrintStream printer;

    @Before
    public void initialise() {
        statement = new Statement();
    }

    @Test
    public void should_print_record_after_header() {
        LocalDateTime transactionTime = LocalDateTime.of(1994, 7, 7, 0, 0);
        Transaction transaction = new Transaction(amountOf(1000), transactionTime);
        Record record = new Record(transaction, amountOf(20000));

        statement.addRecord(record);
        statement.printTo(printer);

        InOrder inOrder = Mockito.inOrder(printer);

        inOrder.verify(printer).println(String.format(LINE_FORMAT, "DATE", "DEPOSIT", "WITHDRAW", "BALANCE"));
        inOrder.verify(printer).println(String.format(LINE_FORMAT, "1994-07-07", "1000.00", "", "20000.00"));
    }
}
