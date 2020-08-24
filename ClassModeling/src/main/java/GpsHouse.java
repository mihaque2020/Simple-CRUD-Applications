/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minul
 */
public class GpsHouse {
    
    private int houseNumber;
    private String address;

    
    public GpsHouse(int houseNumber, String address) {
        
    }
    
    public void setHouseNumber(int number) {
        this.houseNumber = number;
    }
    
    public int getHouseNumber() {
        return houseNumber;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
}
