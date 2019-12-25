/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.domain;

import java.math.BigDecimal;

/**
 *
 * @author maroodb
 */
public class Amount {
    
    private BigDecimal value;
    private static final int SCALE = 2;
    
    public Amount(double value) {
        this.value = BigDecimal.valueOf(value);
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
    
    public boolean isStrictlyPositive() {
        return this.value.compareTo(BigDecimal.ZERO) > 0;
    }
    
 
    public boolean isGreaterOrEqualThan(Amount amount) {
        return this.value.compareTo(amount.value) >= 0;
    }
    
    public Amount negative() {
        return amountOf(this.value.negate().toString());
    }

    @Override
    public boolean equals(Object obj) {
        Amount otherAmount = (Amount) obj;
        
        if(this.value.equals(otherAmount.value)) {
            return true;
        }
        
        return false; 
    }
    
    @Override
    public String toString() {
        return this.value.setScale(SCALE).toString();
    }
    
    
}
