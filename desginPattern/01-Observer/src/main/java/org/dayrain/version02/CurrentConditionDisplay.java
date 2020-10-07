package org.dayrain.version02;

import org.dayrain.version01.impl.CurrentWeatherCondition;
import org.dayrain.version01.interf.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            show();
        }
    }

    @Override
    public void show() {
        System.out.println("current condition is temperature: " + this.temperature + "humidity: " + this.humidity);
    }
}
