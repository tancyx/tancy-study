package com.tancy.desiginPattern.command;

public class CeilingFan {

    public static final int SPEED_HIGH=3;
    public static final int SPEED_MID=2;
    public static final int SPEED_LOW=1;
    public static final int SPEED_OFF=0;

    private int speed=SPEED_OFF;

    public void high(){
        speed=SPEED_HIGH;
        System.out.println("ceilingfan speed "+speed);
    }

    public void mid(){
        speed=SPEED_MID;
        System.out.println("ceilingfan speed "+speed);
    }
    public void low(){
        speed=SPEED_LOW;
        System.out.println("ceilingfan speed "+speed);
    }

    public void on(){
        low();
        System.out.println("ceilingfan on and speed "+speed);
    }

    public void off(){
        speed=SPEED_OFF;
        System.out.println("ceilingfan off and speed "+speed);
    }

    public int getSpeed() {
        return speed;
    }
}
