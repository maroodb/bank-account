/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain.test;

import com.sg.lakata.domain.Amount;
import static com.sg.lakata.domain.Amount.amountOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author maroodb
 */
public class AmountTest {

    @Test
    public void should_be_equal_to_another_instance_containing_same_amount() {
        Amount oneAmount = new Amount(100.15);
        Amount anotherAmount = new Amount("100.15");
        assertThat(oneAmount, is(equalTo(anotherAmount)));
    }

    @Test
    public void should_be_different_from_another_instance_containing_different_amount() {
        Amount amountTen = new Amount(10);
        Amount amountFive = new Amount(5);
        assertThat(amountTen, is(not(equalTo(amountFive))));
    }

    @Test
    public void  should_sum_up_amounts() {
        Amount ten = amountOf(10);
        Amount five = amountOf(5);
        Amount fifteen = amountOf(15);
        assertThat(fifteen, is(equalTo(ten.plus(five))));
    }
    
    @Test
    public void should_negate_amount() {
        Amount ten = amountOf(10);
        Amount minusTen = amountOf(-10);
        assertThat(minusTen, is(equalTo(ten.negative())));
    }
    
    @Test 
    public void should_indicate_when_it_is_greater_or_equal_than_other_amount() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		assertThat(ten.isGreaterOrEqualThan(five), is(true));
	}
    
    @Test
    public void should_indicate_when_it_is_strictly_positive() {
                Amount positiveAmount = amountOf(10);
		assertThat(positiveAmount.isStrictlyPositive(), is(true));
    }
    
    @Test
    public void should_indicate_when_it_is_negative() {
        Amount negativeAmount = amountOf(-10);
		assertThat(negativeAmount.isStrictlyPositive(), is(false));
    }
    
    @Test
    public void should_indicate_when_it_is_zero() {
        Amount negativeAmount = amountOf(0);
		assertThat(negativeAmount.isStrictlyPositive(), is(false));
    }
}
