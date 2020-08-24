/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minul
 */
public class House3D {
    
    
    private double width;
    private double height; 
    private double acreage;
    
    public House3D() {
        
    }
    
    public void setDimensions(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setAcreage(double acres) {
        this.acreage = acres;
    }
    
    public double getAcreage() {
        return acreage;
    }

    public double getArea() {
        return width * height;
    }
}
