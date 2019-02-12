package com.tancy.desiginPattern.command;

public class CeilingFanOffCommand extends AbstractCeilingFanCommand {

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        preSpeed=ceilingFan.getSpeed();
        ceilingFan.off();
    }

}
