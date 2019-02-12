package com.tancy.desiginPattern.factory.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List toppings=new ArrayList();

    public void prepare(){
        System.out.println("preparing "+name);
        System.out.println("tossing dough...");
        System.out.println("adding sauce... ");
        System.out.println("adding toppings: ");
        for (int i=0;i<toppings.size();i++){
            System.out.println("   "+toppings.get(i));
        }
    }

    public void bake(){
        System.out.println("bake for 25min at 350");
    }

    public void cut(){
        System.out.println("cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("place pizza in official pizzastore box");
    }

    public String getName(){
        return name;
    }

}
