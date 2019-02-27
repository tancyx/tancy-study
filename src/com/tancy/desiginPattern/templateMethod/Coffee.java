package com.tancy.desiginPattern.templateMethod;

/**
 * @author tancy
 * @description 泡制咖啡
 * @date 2019/2/27 18:09
 **/
public class Coffee extends CaffeineBeverage {

    @Override
    public void brew(){
        System.out.println("dripping coffee through filter");
    }

    @Override
    public void addCondiments(){
        System.out.println("adding sugar and milk");
    }

}
