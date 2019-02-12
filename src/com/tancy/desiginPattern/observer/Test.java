package com.tancy.desiginPattern.observer;

public class Test {

    public static void main(String[] args) {
        WeatherData wd=new WeatherData();
        CurrentConditionsDisplay ccd=new CurrentConditionsDisplay();
        StatisticsDisplay ssd=new StatisticsDisplay();
        ForecastDisplay fd=new ForecastDisplay();
        wd.registeObserver(ccd);
        wd.registeObserver(ssd);
        wd.registeObserver(fd);

        wd.setMeasurements(25.0f,12.3f,1.1f);



    }
}
