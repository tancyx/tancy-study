package com.tancy.desiginPattern.decorator;

public class Test {

    public static void main(String[] args) {
        DarkRoast dr=new DarkRoast(DarkRoast.CUPSIZE_TALL);
        dr.getDescription();
        System.out.println(dr.cost());
        Milk milk=new Milk();
        milk.setBeverage(dr);
        milk.getDescription();
        System.out.println(milk.cost());
        Mocha mocha=new Mocha();
        mocha.setBeverage(milk);
        mocha.getDescription();
        System.out.println(mocha.cost());
    }
}
