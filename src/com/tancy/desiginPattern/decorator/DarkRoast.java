package com.tancy.desiginPattern.decorator;

public class DarkRoast extends Beverage {

    public DarkRoast() {
    }

    public DarkRoast(float size) {
        setSize(size);
    }

    @Override
    public String getDescription() {
        System.out.println("origin darkroast");
//        if (getSize()==CUPSIZE_TALL) System.out.println("cup tall");
//        if (getSize()==CUPSIZE_GRAND) System.out.println("cup grand");
//        if (getSize()==CUPSIZE_VENTI) System.out.println("cup venti");
        return "origin darkroast";
    }

    @Override
    public float cost() {
        return 10.00f+getCupSize();
    }

    @Override
    public float getCupSize() {
        return getSize();
    }

    @Override
    public void setCupSize() {

    }
}
