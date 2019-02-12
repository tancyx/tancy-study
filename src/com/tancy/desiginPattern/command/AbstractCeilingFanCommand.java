package com.tancy.desiginPattern.command;

public abstract class AbstractCeilingFanCommand implements Command {

    protected CeilingFan ceilingFan;

    protected int preSpeed;

    public AbstractCeilingFanCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void undo() {
        switch (preSpeed){
            case CeilingFan.SPEED_OFF :ceilingFan.off();return;
            case CeilingFan.SPEED_LOW :ceilingFan.low();return;
            case CeilingFan.SPEED_MID :ceilingFan.mid();return;
            case CeilingFan.SPEED_HIGH :ceilingFan.high();return;
        }
    }
}
