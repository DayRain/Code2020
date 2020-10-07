package org.dayrain.version01.impl;

import org.dayrain.version01.interf.Observer;
import org.dayrain.version01.interf.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private float temperature;

    private float humidity;

    private List<Observer>observers;

    public WeatherData(){
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index >= 0){
            observers.remove(observer);
        }
    }


    public void setWeatherData(float temperature, float humidity){
        this.temperature = temperature;
        this.humidity = humidity;
        notifyAllObserver();
    }



    @Override
    public void notifyAllObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperature, this.humidity);
        }
    }
}
