package com.tancy.desiginPattern.factory;

import com.tancy.desiginPattern.factory.factoryMethod.Pizza;

public class CheesePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pif) {
        this.pizzaIngredientFactory=pif;
    }

    @Override
    public void prepare() {
//        pizzaIngredientFactory.createDough();
//        pizzaIngredientFactory.createSauce();
    }
}
