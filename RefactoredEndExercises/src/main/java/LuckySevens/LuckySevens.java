/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuckySevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Minul
 */
public class LuckySevens {
    
    public void play() {
            
        Scanner sc = new Scanner(System.in);
        System.out.print("How much would you like to bet? ");
        float bet = Integer.parseInt(sc.nextLine());
        
        int rolls = 0;
        float max = bet;
        int die1, die2;
        int sum = 0;
        int peakRoll = 0;
        
        Random rng = new Random();
        
        while (bet != 0) {
            
            die1 = rng.nextInt(6) + 1;
            die2 = rng.nextInt(6) + 1;
            sum = die1 + die2;
            
            if (sum == 7) {
                bet += 4;
            } else {
                bet--;
            }
            rolls++;
            
            if (bet > max) {
                max = bet;
                peakRoll = rolls;
            }
            
        }
        System.out.println("You are broke after " + rolls + " rolls.");
        System.out.println("You should have quit after " + peakRoll + " rolls when you had $" + max);
    }
}
