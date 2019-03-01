package com.tancy.desiginPattern.templateMethod;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 18:20
 **/
public abstract class CaffeineBeverage {

    public void prepare(){
        boilWater();
        brew();
        pourInCup();
        if (wantAddCondiments())
            addCondiments();
    }

    public void boilWater(){
        System.out.println("boiling water");
    }

    public void pourInCup(){
        System.out.println("pouring into cup");
    }

    public abstract void brew();

    public abstract void addCondiments();

    //hook
    public boolean wantAddCondiments(){
        return true;
    }

}
