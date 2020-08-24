/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minul
 */
public class TrafficAirplane {
    
    private String departureTime;
    private String airline;
    private String flightNumber;
    private String gate;
    
    public TrafficAirplane() {
        
    }
    
    public void setDepartureTime(String time) {
        this.departureTime = time;
    }
    
    public String getDepartureTime(String time) {
        return departureTime;
    }
    
    public void setAirline(String airline) {
        this.airline = airline;
    }
    
    public String getAirline() {
        return airline;
    }
    
    public void setFlightNumber(String number) {
        this.flightNumber = number;
    }
    
    public String getFlightNumber() {
        return flightNumber;
    }
    
    public void setGate(String gate) {
        this.gate = gate;
    }
    
    public String getGate() {
        return gate;
    }
}
