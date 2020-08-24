/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterestCalculator;

import java.util.Scanner;

/**
 *
 * @author Minul
 */
public class InterestCalculator {
    
    public void calculate() {
     // Get user inputs
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How much do you want to invest? ");
        float investment  = Integer.parseInt(sc.nextLine());
        System.out.print("How many years are you investing? ");
        float investmentYears  = Integer.parseInt(sc.nextLine());
        System.out.print("What is the annual interest rate % growth? ");
        float annualInterestRate = Integer.parseInt(sc.nextLine());
        System.out.print("Would you like to see quarterly, monthly, or daily periods? ");
        String choice = sc.nextLine();
        float earnings = 0;
        
        System.out.println("Calculating...");
        
        // Decide frequency in which data is shown
        if (choice.equalsIgnoreCase("quarterly")) {
            for (int i = 1; i <= investmentYears * 4; i++) {
                System.out.println("Quarter: " + i);
                System.out.println("Began with " + investment);
                earnings = getEarnings(investment, annualInterestRate / 4 );
                System.out.println("Earned: " + earnings);
                investment += earnings;
                System.out.println("Ended with: " + investment);
            }
        } else if (choice.equalsIgnoreCase("monthly")) {
            for (int i = 1; i <= investmentYears * 12; i++) {
                System.out.println("Month: " + i);
                System.out.println("Began with " + investment);
                earnings = getEarnings(investment, annualInterestRate / 12);
                System.out.println("Earned: " + earnings);
                investment += earnings;
                System.out.println("Ended with: " + investment);
            }
        } else if (choice.equalsIgnoreCase("daily")) {
            for (int i = 1; i <= investmentYears * 365; i++) {
                System.out.println("Day: " + i);
                System.out.println("Began with " + investment);
                earnings = getEarnings(investment, annualInterestRate / 365);
                System.out.println("Earned: " + earnings);
                investment += earnings;
                System.out.println("Ended with: " + investment);
            }
        } else {
            for (int i = 1; i <= investmentYears; i++) {
                System.out.println("Year: " + i);
                System.out.println("Began with " + investment);
                earnings = getEarnings(investment, annualInterestRate);
                System.out.println("Earned: " + earnings);
                investment += earnings;
                System.out.println("Ended with: " + investment);
            }
        }
        
    }
    
    public float getEarnings(float currentBalance, float interestRate) {
            return currentBalance * (interestRate / 100);
    }

}
