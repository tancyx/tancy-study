package com.tancy.desiginPattern.observer;

import java.util.Objects;

public class CurrentConditionsDisplay implements Observer,DisplayElement {

    private float temp;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        System.out.println("Current Conditions====================================");
        System.out.println("temp:"+temp+",humidity:"+humidity+",pressure:"+pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        this.display();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentConditionsDisplay that = (CurrentConditionsDisplay) o;
        return Float.compare(that.temp, temp) == 0 &&
                Float.compare(that.humidity, humidity) == 0 &&
                Float.compare(that.pressure, pressure) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, humidity, pressure);
    }
}
