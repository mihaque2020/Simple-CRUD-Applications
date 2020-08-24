/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactorizerApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Minul
 */
public class Factorizer {

    private int factorCount = 0;
    private int factorSum = 0;
        

    // Create factor list
    
    public void factorize() {
        
        System.out.print("What number would you like to factor? ");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        
        ArrayList<Integer> factorList = new ArrayList<Integer>();
        
        for (int i = 1; i <= num; i++) {
            
            if (num % i == 0) {
                factorCount++;
                factorList.add(i);
            }
        }
        
        factorSum = sumFactors(num, factorList);
        
        if (factorSum == num) {
            printFactors(factorList);
            isPerfect(num, factorCount);
        } else if (factorSum == num + 1) {
            printFactors(factorList);
            isPrime(num);
        } else {
            printFactors(factorList);
            isOther(num, factorCount);
        }
    }
               
    public int sumFactors(int num, ArrayList<Integer> arrayList) {
        int sum = 0;
        System.out.println("The factors of " + num + " are: ");
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        sum -= num;
        return sum;
    }
    
    public void isPerfect(int num, int factorCount) {
        System.out.println(num + " has " + factorCount + " factors.");
        System.out.println(num + " is a perfect number.");
        System.out.println(num + " is not a prime number.");
    }

    public void isPrime(int num) {
        System.out.println(num + " has 2 factors.");
        System.out.println(num + " is not a perfect number.");
        System.out.println(num + " is a prime number.");
    } 
    
    public void isOther(int num, int factorCount) {
        System.out.println(num + " has " + factorCount + " factors.");
        System.out.println(num + " is not a perfect number.");
        System.out.println(num + " is not a prime number.");
    }
    
    public void printFactors(ArrayList<Integer> factors) {
        for (int i = 0; i < factors.size(); i++){
            System.out.print(factors.get(i) + " ");
        }
        System.out.println("");
    } 
}
