package com.tancy.desiginPattern.observer.jdkObserver;

import com.tancy.desiginPattern.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private WeatherData.SubjectData sd=null;

    @Override
    public void update(Observable o, Object arg) {
        if (arg==null){

        }else {
            this.sd= (WeatherData.SubjectData) arg;
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current Conditions====================================");
        System.out.println("temp:"+sd.getTemp()+",humidity:"+sd.getHumidity()+",pressure:"+sd.getPressure());
    }

    public WeatherData.SubjectData getSd() {
        return sd;
    }

    public void setSd(WeatherData.SubjectData sd) {
        this.sd = sd;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        return false;
    }
}
