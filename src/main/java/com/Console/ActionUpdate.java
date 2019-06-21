package com.Console;

public class ActionUpdate implements IAction {


    @Override
    public String getName() {
        return "Update";
    }


    @Override
    public void action() {
        System.out.println("<-------<Update>------->");
        ObjectConsole.ConsoleUpdate = true;

    }
}
