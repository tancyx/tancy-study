package com.tancy.desiginPattern.adapter;

public class Test {

    public static void main(String[] args) {
        Duck turkeyAdapter=new TurkeyAdapter(new WildTurkey());
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }

}
