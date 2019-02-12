package com.tancy.desiginPattern.command;

import java.util.LinkedList;

public class MacroCommand implements Command {

    private LinkedList<Command> list;

    public MacroCommand(LinkedList<Command> list) {
        this.list = list;
    }

    @Override
    public void execute() {
        for (Command cmd :
                list) {
            cmd.execute();
        }
    }

    @Override
    public void undo() {
        for (Command cmd :
                list) {
            cmd.undo();
        }
    }
}
