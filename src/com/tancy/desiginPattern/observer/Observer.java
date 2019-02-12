package com.tancy.desiginPattern.observer;

/**
 * 观察者接口，所有观察类都需要实现
 */
public interface Observer {


    public void update(float temp,float humidity,float pressure);


}
