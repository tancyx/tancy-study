package com.tancy.desiginPattern.observer.jdkObserver;

import java.util.Observable;

public class WeatherData extends Observable {

    private SubjectData sd=null;

    public WeatherData() {
        this.sd = new SubjectData();
    }


    public void setSubjectData(SubjectData sjd){
        this.sd=sjd;
        setChanged();
        notifyObservers(sd);
    }



    class SubjectData {
        private float temp;
        private float humidity;
        private float pressure;

        public SubjectData() {
        }

        public SubjectData(float temp, float humidity, float pressure) {
            this.temp = temp;
            this.humidity = humidity;
            this.pressure = pressure;
        }

        public float getTemp() {
            return temp;
        }

        public SubjectData setTemp(float temp) {
            this.temp = temp;
            return this;
        }

        public float getHumidity() {
            return humidity;
        }

        public SubjectData setHumidity(float humidity) {
            this.humidity = humidity;
            return this;
        }

        public float getPressure() {
            return pressure;
        }

        public SubjectData setPressure(float pressure) {
            this.pressure = pressure;
            return this;
        }
    }

}
