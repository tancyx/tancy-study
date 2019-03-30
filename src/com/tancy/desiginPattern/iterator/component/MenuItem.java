package com.tancy.desiginPattern.iterator.component;

/**
 * @author tancy
 * @description description
 * @date 2019/3/29 19:00
 **/
public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private double price;
    private boolean vegetarian;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.println("MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                '}');
    }

}
