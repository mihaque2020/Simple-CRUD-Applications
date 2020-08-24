/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minul
 */
public class GroceryIceCream {
    
    private String company;
    private String flavor;
    private double price;
    private int stock;
    private int itemNumber;
    
    public GroceryIceCream(String company, String flavor, double price, int stock, int itemNumber) {
        this.company = company;
        this.flavor = flavor;
        this.price = price;
        this.stock = stock;
        this.itemNumber = itemNumber;
        
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    
    public String getFlavor() {
        return flavor;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
    
    public int getItemNumber() {
        return itemNumber;
    }
}
