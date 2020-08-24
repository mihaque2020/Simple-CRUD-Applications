/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Minul
 */
public class RockPaperScissors {
    
    public void play() {
    // Ability to replay
        int play = 1;
        while (play == 1) {
            
            // Get user input for rounds
            Scanner sc = new Scanner(System.in);
            System.out.println("How many rounds would you like to play? (1 - 10) ");
            int rounds = Integer.parseInt(sc.nextLine());
            
            
            // Error check input
            if (rounds < 1 || rounds > 10) {
                System.out.println("ERROR! Rounds outside of range. Exiting game...");
                play = 0;
                break;
            }
            
            int[] winsLossesTies = {0, 0, 0}; // index 0: wins 1: losses, 2: ties
            
            // Game loop runs for number of rounds requested
            while (rounds > 0) {
                
                // Get user choice
                int userChoice = 0;
                while (userChoice == 0) { // Error Check Input
                    System.out.println("What do you want to play? (Rock, Paper, or Scissor) ");
                    String strUserChoice = sc.nextLine();
                    userChoice = convertChoice(strUserChoice); // maps inputs to numbers
                }
                
                // Generate random computer choice
                Random rng = new Random();
                int compChoice = rng.nextInt(3) + 1;

                // Determine if user wins, loses, or ties and increments respective result
                if (userChoice == compChoice) {
                    System.out.println("Looks like it's a... TIE!");
                    winsLossesTies[2]++;
                } else if (userChoice == 1) {
                    if (compChoice == 3) {
                        System.out.println("CONGRATS YOU WIN!");
                        winsLossesTies[0]++;
                    } else {
                        System.out.println("SORRY you lose...");
                        winsLossesTies[1]++;
                    }
                } else if (userChoice == 2) {
                    if (compChoice == 1) {
                        System.out.println("CONGRATS YOU WIN!");
                        winsLossesTies[0]++;
                    } else {
                        System.out.println("SORRY you lose...");
                        winsLossesTies[1]++;
                    }
                } else if (userChoice == 3) {
                     if (compChoice == 2) {
                        System.out.println("CONGRATS YOU WIN!");
                        winsLossesTies[0]++;
                    } else {
                        System.out.println("SORRY you lose...");
                        winsLossesTies[1]++;
                    }
                }
                rounds--;
            }
            play = 0;
            
            // Display game results
            System.out.println("RESULTS: ");
            System.out.println("Wins: " + winsLossesTies[0] + "  Losses: " + winsLossesTies[1] + "  Ties: " + winsLossesTies[2]);
            
            // Determin whether user wants to play again or end the session
            System.out.println("Would you like to play again? yes/no ");
            String playAgain = sc.nextLine();
            if (playAgain.equalsIgnoreCase("yes")) {
                play = 1;
            }
        }
        System.out.println("Thanks for playing!");
    }
    
    // Method maps rock to 1, paper to 2, and Scissor to 3
    public int convertChoice(String choice) {
        if (choice.equalsIgnoreCase("Rock")) {
            return 1;
        } else if (choice.equalsIgnoreCase("Paper")) {
            return 2;
        } else if (choice.equalsIgnoreCase("Scissor")) {
            return 3;
        }
        return 0;
    }
}
