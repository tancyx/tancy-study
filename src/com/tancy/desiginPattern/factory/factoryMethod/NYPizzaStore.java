package com.tancy.desiginPattern.factory.factoryMethod;

public class NYPizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "cheese": return new NYStyleCheesePizza();

            default: return null;
        }
    }
}
