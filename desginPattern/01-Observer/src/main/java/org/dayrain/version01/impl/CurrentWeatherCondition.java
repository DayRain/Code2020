package org.dayrain.version01.impl;

import org.dayrain.version01.interf.DisplayElement;
import org.dayrain.version01.interf.Observer;

public class CurrentWeatherCondition implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentWeatherCondition(WeatherData weatherData){
        this.weatherData = weatherData;
    }

    @Override
    public void show() {
        System.out.println("current condition is : temperature: " + temperature+" humidity: " + humidity);
    }

    @Override
    public void update(float temperature, float humidity) {
        this.temperature = temperature ;
        this.humidity = humidity;
        show();
    }
}
