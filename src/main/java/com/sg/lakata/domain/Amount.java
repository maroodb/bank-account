/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author maroodb
 */
public class Amount {
    
    private BigDecimal value;
    
    public Amount(double value) {
        this.value = new BigDecimal(value);
    }
    
    public Amount(String value) {
        this.value = new BigDecimal(value);
    }
    
    public static Amount amountOf(double value) {
        return new Amount(value);
    }
    
    public static Amount amountOf(String value) {
        return new Amount(value);
    }
    
    public Amount plus(Amount amount) {
        return amountOf(this.value.add(amount.value).toString());
    }
}
