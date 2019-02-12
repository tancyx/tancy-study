package com.tancy.desiginPattern.command;

public class CeilingFanHighCommand extends AbstractCeilingFanCommand {

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        preSpeed=ceilingFan.getSpeed();
        ceilingFan.high();
    }
}
