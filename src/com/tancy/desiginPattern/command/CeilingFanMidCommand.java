package com.tancy.desiginPattern.command;

public class CeilingFanMidCommand extends AbstractCeilingFanCommand {

    public CeilingFanMidCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        preSpeed=ceilingFan.getSpeed();
        ceilingFan.mid();
    }
}
