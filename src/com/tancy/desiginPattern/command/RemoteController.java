package com.tancy.desiginPattern.command;

import java.util.ArrayList;
import java.util.List;

public class RemoteController {

    public static final int SLOTNUM_DEFAULT=8;

    private List<Command> slotsOn=new ArrayList<>();
    private List<Command> slotsOff=new ArrayList<>();

    private Command undoCommand;

    public RemoteController() {
        for (int i=0;i<SLOTNUM_DEFAULT;i++){
            slotsOn.add(new NoCommand());
            slotsOff.add(new NoCommand());
        }
    }

    public void setSlot(int index,Command onCommand,Command offCommand){
        slotsOn.set(index,onCommand);
        slotsOff.set(index,offCommand);
    }

    public void clearSlot(int index){
        slotsOn.set(index,new NoCommand());
        slotsOff.set(index,new NoCommand());
    }

    public void pressButtonOn(int index){
        (undoCommand=slotsOn.get(index)).execute();
    }

    public void pressButtonOff(int index){
        (undoCommand=slotsOff.get(index)).execute();
    }

    public void pressButtonUndo(){
        System.out.println("press undo");
        undoCommand.undo();
    }

}
