package com.example.weatherforecast.Models;

public class UserInput {

    // Variables
    private String city;
    private String state;

    // Default-Constructor
    public UserInput() {
    }

    // Constructor
    public UserInput(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
