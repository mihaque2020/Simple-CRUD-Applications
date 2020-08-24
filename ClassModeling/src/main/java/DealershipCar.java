/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minul
 */
public class DealershipCar {
    
    private String make;
    private String model;
    private int year;
    private int mileage; 
    private double price;
    
    public DealershipCar(String make, String model, int year, int mileage, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setYear(int year) {
        this.year = year;
    } 
    
    public int getYear() {
        return year;
    }
    
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    public int getMileage() {
        return mileage;
    }
    
    public void setPrice (double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
}
