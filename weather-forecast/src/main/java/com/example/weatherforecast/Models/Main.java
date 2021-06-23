package com.example.weatherforecast.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    // Variables
    private float temp;

    // Default-Constructor
    public Main() {
    }


    // Getters and Setters
    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }
}
