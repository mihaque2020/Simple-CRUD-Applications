/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minul.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author Minul
 */
public class App {
    
    public static void main(String[] args) {
        
        System.out.println("Welcome to Simple Calculator!");
        boolean continu = true;
        while (continu) {
            
            // Present menu options
            System.out.println("Select an option from the menu: ");
            System.out.println("1 - Add                 2 - Subtract");
            System.out.println("3 - Multiply            4 - Divide");
            System.out.println("5 - Quit Program");

            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            
            // Exit out of program
            if (choice == 5) {
                continu = false;
                break;
            }
            
            // Get operands from user
            System.out.print("Enter operand1: ");
            float operand1 = Float.parseFloat(sc.nextLine());
            System.out.print("Enter operand2: ");
            float operand2 = Float.parseFloat(sc.nextLine());
                    
            float result = 0;
            
            // selected calculator operations
            switch(choice) {

                case 1:
                    result = SimpleCalculator.add(operand1, operand2);
                    break;
                case 2: 
                    result = SimpleCalculator.subtract(operand1, operand2);
                    break;
                case 3:
                    result = SimpleCalculator.multiply(operand1, operand2);
                    break;
                case 4:
                    result = SimpleCalculator.divide(operand1, operand2);
                    break;
                default:
                    System.out.println("Incorrect menu choice");
            }
            
            // Output calculator results
            System.out.println("Result: " + result);
            System.out.println("");
        }
        System.out.println("Thank you!");
        System.out.println("");
    }
}
