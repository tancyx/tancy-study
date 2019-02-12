package com.tancy.desiginPattern.observer;

/**
 * 主题接口，所有主题类都要实现
 */
public interface Subject {

    public void registeObserver(Observer observer);

    public boolean removeObserver(Observer observer);

    public void notifyObservers();

}
