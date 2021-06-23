# SpringMVC-WeatherForecast

This SpringMVC Web Application (Maven) allows the user to retrieve weather information with the help of an API (OpenWeatherMap):

  - User types in information; city and state
  - Program uses String interpolation to merge user input with the API key, resulting in a URL request
  - JSON response is then converted to a POJO (Plain Old Java Object) in order to access requested data for user
  - Data is then displayed to the user in the View



*DEPENDENCIES: 
  - SpringWeb
  - Thymleaf
  - Springboot Dev Tools
