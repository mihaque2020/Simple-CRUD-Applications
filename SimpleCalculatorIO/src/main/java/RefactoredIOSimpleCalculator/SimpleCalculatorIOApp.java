/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactoredIOSimpleCalculator;

/**
 *
 * @author Minul
 */
public class SimpleCalculatorIOApp {
    public static void main(String[] args) {
        
        UserIO2 io = new UserIOImp2();
        
        boolean isValid = false;
        while (!isValid) {
            
            // Present menu and get users choice of operation
            io.print("Welcome to Simple Calculator!");
            int choice = io.readInt("Select an option from the menu:\n"+
                   "1 - Add                 2 - Subtract\n" + "3 - Multiply            4 - Divide\n" +
                    "5 - Quit Program");

            // Exit out of program
            if (choice == 5) {
                isValid = true;
                break;
            }        
            
            // Get user inputs of operands
            float operand1 = io.readFloat("Enter your first number: ");
            float operand2 = io.readFloat("Enter your second number: ");
            
            float result = 0;
            
            // Execute respective mathematical operations
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
                    io.print("Incorrect menu choice...");
            }
                
            io.print("Result: " + result);
            io.print("");
        }
        io.print("Thank you!");
        io.print("");
    }
}
