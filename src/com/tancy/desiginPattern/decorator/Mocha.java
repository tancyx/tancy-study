package com.tancy.desiginPattern.decorator;

public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    @Override
    public String getDescription() {
        beverage.getDescription();
        System.out.println("add mocha");
        return "add mocha";
    }

    @Override
    public float getCupSize() {
        return beverage.getCupSize();
    }

    @Override
    public void setCupSize() {

    }

    @Override
    public float cost() {
        float cost=1.00f+beverage.cost();
        if (getCupSize()==CUPSIZE_TALL) cost+=CUPSIZE_TALL;
        if (getCupSize()==CUPSIZE_GRAND) cost+=CUPSIZE_GRAND;
        if (getCupSize()==CUPSIZE_VENTI) cost+=CUPSIZE_VENTI;
        return cost;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }
}
