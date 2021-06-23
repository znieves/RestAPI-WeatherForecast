package com.example.weatherforecast.Controller;

import com.example.weatherforecast.Models.Main;
import com.example.weatherforecast.Models.UserInput;
import com.example.weatherforecast.Models.WeatherReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;


@Controller
@RequestMapping("MyMVC")
public class HomeController {

    static WeatherReport forecast = new WeatherReport();
    static Main temperature = new Main();

    /*
    * Create the ObjectMapper object to map JSON response Object to the POJO
    * ObjectMapper objectMapper = new ObjectMapper(); ***Might need a try-catch block for Exceptions
    *
    * (Validation must be applied to user input before concatenation with URL. If failed to retrieve results, notify
    * user and ask them to try again)
    *
    * Create WeatherReport Object (POJO) to contain the JSON response Object, also create the secondary/nested POJO "Main" to contain
    * the nested JSON response Object "main" to access specific results on weather.
    * */

    // Display Form for user input
    @GetMapping("/weather-forecast")
    public String getHomePage(Model model){
        model.addAttribute("userData", new UserInput());
        return "weather-home";
    }

    // Allow user to input information (City, State) to retrieve proper data from OpenWeather API
    @PostMapping("/weather-forecast")
    public String addLocationData(@ModelAttribute UserInput userInput, @RequestParam String city, @RequestParam String state, Model model){

        // Get Weather information correlating to city, state. (Control is returned to this "caller" method once complete.
        getTemperature(userInput);

        // Add Weather Report and Main POJO to a public Object in the Controller - static variables at top of class (forecast, temperature)
        model.addAttribute("City",forecast);
        model.addAttribute("Temperature", temperature);

        // Redirect to "/MyMVC/weather-report" after action is committed (URL might be incorrect)
        return "weather-report";
    }

    // Method for getting temperature of city
    public static void getTemperature(UserInput input){
       try {
           // Create the Object Mapper Object
           ObjectMapper objectMapper = new ObjectMapper();

           /*Send request for data using user input. String interpolation of user input (city, state) with API URL
           If the input is invalid, the URL will be incorrect, resulting in the program throwing a "FileNotFound" Exception
            */
           URL url = new URL(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s,%s,US&units=imperial&appid=3c1c2ae827ea763206b51641751ed735", input.getCity(), input.getState()));

           // Convert the JSON response Object to a POJO (Set nested "main" Object to its own POJO to access temp property)
           forecast = objectMapper.readValue(url, WeatherReport.class);
           temperature = forecast.getMain();
       }
       catch (Exception ex){

               ex.printStackTrace();

       }
    }
}
