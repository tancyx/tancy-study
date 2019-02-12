package com.tancy.desiginPattern.command;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        Light light=new Light("bedroom light");
        Command cmd=new LightOnCommand(light);
        cmd.execute();
        CeilingFan ceilingFan =new CeilingFan();
//        cmd=new CeilingFanLowCommand(ceilingFan);
//        cmd.execute();

        System.out.println("====================================");

        RemoteController rc=new RemoteController();
        rc.setSlot(0,new LightOnCommand(light),new LightOffCommand(light));
        rc.setSlot(1,new CeilingFanLowCommand(ceilingFan),new CeilingFanOffCommand(ceilingFan));
        rc.setSlot(2,new CeilingFanMidCommand(ceilingFan),new NoCommand());
        rc.setSlot(3,new CeilingFanHighCommand(ceilingFan),new NoCommand());
        LinkedList<Command> list=new LinkedList<>();
        list.add(new LightOnCommand(light));
        list.add(new CeilingFanLowCommand(ceilingFan));
        rc.setSlot(4,new MacroCommand(list),new NoCommand());
//        rc.pressButtonOn(1);
//        rc.pressButtonOff(1);
//        rc.pressButtonOn(0);
//        rc.pressButtonOn(2);
//        rc.pressButtonOn(3);
//        rc.pressButtonUndo();
        rc.pressButtonOn(4);
        rc.pressButtonUndo();
    }


}
