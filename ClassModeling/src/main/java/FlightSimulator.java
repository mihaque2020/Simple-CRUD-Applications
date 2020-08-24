/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minul
 */
public class FlightSimulator {
    
    private float altitude;
    private float velocity;
    private boolean landingGear;
    
    public FlightSimulator() {
        
    }
    
    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }
    
    public float getAltitude() {
        return altitude;
    }
    
    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }
    
    public float getVelocity() {
        return velocity;
    }
    
    public void setLandingGear(boolean bool) {
        this.landingGear = bool;
    }
    
    public boolean getLandingGear() {
        return landingGear;
    }
}
