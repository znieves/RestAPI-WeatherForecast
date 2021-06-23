package com.example.weatherforecast.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Annotation: Ignore the properties in the JSON response Object that I don't reference in this class
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReport {

    // Variables
    private String name;
    private Main main;

    // Default-Constructor
    public WeatherReport() {
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
