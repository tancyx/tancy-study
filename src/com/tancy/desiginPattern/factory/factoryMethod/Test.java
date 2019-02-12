package com.tancy.desiginPattern.factory.factoryMethod;

public class Test {

    public static void main(String[] args) {
        PizzaStore ps=new ChicagoPizzaStore();
        ps.orderPiazza("cheese");
    }
}
