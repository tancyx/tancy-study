package com.tancy.desiginPattern.factory.factoryMethod;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "cheese": return new ChicagoStyleCheesePizza();

            default: return null;
        }
    }
}
