/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minul.studentquizscores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Minul
 */
public class StudentQuizScores {
    public static void main(String[] args) {
        
        UserIO io = new UserIOImp();
        Map<String, List<Double>> map = new HashMap<>();
        List<Double> quizGrades = new ArrayList<>();
        
        boolean isValid = false;
        while(!isValid) {
        
            // Get what the user would like to do
            int choice = io.readInt("Select an option from the menu:\n"+
                "1 - View a list of Students in the system         2 - Add Student to the System\n" + 
                "3 - Remove a Student from the system              4 - View a Student's quiz scores\n" +
                "5 - View a Student's average quiz score           6 - Quit program");
            
            // Exit out of program
            if (choice == 6) {
                isValid = true;
                break;
            }
            
            switch(choice) {
                
                case 1:
                    io.print("Students:");
                    Set<String> students = map.keySet();
                    for (String student : students) {
                        io.print(student);
                    }
                    break;
                    
                case 2: 
                    String newStudent = io.readString("Enter new student's name: ");
                    map.put(newStudent, null);
                    break;
                
                case 3:
                    String removedStudent = io.readString("Enter name of student to remove: ");
                    map.remove(removedStudent);
                    break;
                  
                case 4:
                    String student = io.readString("Enter Student name to recieve their quiz scores: ");
                    System.out.println(map.get(student));
                    break;
                
                case 5:
                    
            }
            
        }
        
    }
}
