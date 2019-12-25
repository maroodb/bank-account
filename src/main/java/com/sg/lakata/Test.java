/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lakata;

/**
 *
 * @author mdbouba
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        String format = "|%1$-10s|%2$-10s|%3$-20s|\n";
        System.out.format(format, "Date", "Deposit", "Withdraw");
        System.out.format(format, "21/12/2020", "", "1250000.5");
         System.out.format(format, "21/12/2019", "12000", "12500");
         System.out.format(format, "21/12/2019", "12000", "");

       
        String ex[] = {"E", "EEEEEEEEEE", "E"};

        System.out.format(String.format(format, (Object[]) ex));
        
        
    }

}
