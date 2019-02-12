package com.tancy.desiginPattern.command;

public class CeilingFanLowCommand extends AbstractCeilingFanCommand {

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        preSpeed= ceilingFan.getSpeed();
        ceilingFan.on();
    }

}
