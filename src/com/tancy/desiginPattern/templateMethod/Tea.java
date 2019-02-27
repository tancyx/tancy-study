package com.tancy.desiginPattern.templateMethod;

/**
 * @author tancy
 * @description 泡制茶
 * @date 2019/2/27 18:16
 **/
public class Tea extends CaffeineBeverage {

    @Override
    public void brew(){
        System.out.println("steeping tea bag");
    }

    @Override
    public void addCondiments(){
        System.out.println("adding lemon");
    }

}
