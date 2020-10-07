package org.dayrain.version01.impl;

public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentWeatherCondition currentWeatherCondition = new CurrentWeatherCondition(weatherData);
        weatherData.registerObserver(currentWeatherCondition);
        weatherData.setWeatherData(1.5F,2.0F);
    }
}
