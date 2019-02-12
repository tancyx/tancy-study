package com.tancy.desiginPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList();
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    @Override
    public void registeObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob:
             this.observers) {
            ob.update(temp,humidity,pressure);
        }
    }

    public void setMeasurements(float temp,float humidity,float pressure){
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        this.measurementsChanged();
    }

}
