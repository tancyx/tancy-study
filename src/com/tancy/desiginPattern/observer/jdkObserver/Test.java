package com.tancy.desiginPattern.observer.jdkObserver;

import java.util.Observer;

public class Test {

    public static void main(String[] args) {

        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay ob=new CurrentConditionsDisplay();
        weatherData.addObserver(ob);
        WeatherData.SubjectData wsd=weatherData.new SubjectData();

        wsd.setTemp(11.11f).setHumidity(11.11f).setPressure(11.11f);
        weatherData.setSubjectData(wsd);
//        weatherData.deleteObserver(ob);

        wsd.setTemp(11.12f).setHumidity(11.12f).setPressure(11.12f);
        weatherData.setSubjectData(wsd);

    }

}
