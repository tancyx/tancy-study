package com.tancy.desiginPattern.factory.factoryMethod;

public abstract class PizzaStore {

    public Pizza orderPiazza(String type){
        Pizza pizza=createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
