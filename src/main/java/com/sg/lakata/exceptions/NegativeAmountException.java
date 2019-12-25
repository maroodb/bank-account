/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata.exceptions;

/**
 *
 * @author mdbouba
 */
public class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
		super(message);
	}
}
