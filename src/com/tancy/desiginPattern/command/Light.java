package com.tancy.desiginPattern.command;

public class Light {

    private String lightName;

    public Light(String lightName) {
        this.lightName = lightName;
    }

    public void on(){
        System.out.println(lightName+" on ");
    }

    public void off(){
        System.out.println(lightName+" off ");
    }

}
