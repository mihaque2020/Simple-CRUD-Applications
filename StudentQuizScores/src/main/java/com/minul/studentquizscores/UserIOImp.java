/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minul.studentquizscores;

import java.util.Scanner;

/**
 *
 * @author Minul
 */
public class UserIOImp implements UserIO {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        return message;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        int response = Integer.parseInt(sc.nextLine());
        return response;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt + "Range: " + min + "-" + max);
        Scanner sc = new Scanner(System.in);
        int response = Integer.parseInt(sc.nextLine());      
        
        while (min > response || response > max) {
            System.out.println(prompt + "Range: " + min + "-" + max);
            response = Integer.parseInt(sc.nextLine()); 
        }
        return response;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        double response = Double.parseDouble(sc.nextLine());
        return response;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt + "Range: " + min + "-" + max);
        Scanner sc = new Scanner(System.in);
        double response = Integer.parseInt(sc.nextLine());      
        
        while (min > response || response > max) {
            System.out.println(prompt + "Range: " + min + "-" + max);
            response = Double.parseDouble(sc.nextLine()); 
        }
        return response;   
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        float response = Float.parseFloat(sc.nextLine());
        return response;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt + "Range: " + min + "-" + max);
        Scanner sc = new Scanner(System.in);
        float response = Integer.parseInt(sc.nextLine());      
        
        while (min > response || response > max) {
            System.out.println(prompt + "Range: " + min + "-" + max);
            response = Float.parseFloat(sc.nextLine());
        }
        return response; 
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        long response = Long.parseLong(sc.nextLine());
        return response;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt + "Range: " + min + "-" + max);
        Scanner sc = new Scanner(System.in);
        long response = Integer.parseInt(sc.nextLine());      
        
        while (min > response || response > max) {
            System.out.println(prompt + "Range: " + min + "-" + max);
            response = Long.parseLong(sc.nextLine());
        }
        return response; 
    }
    
}