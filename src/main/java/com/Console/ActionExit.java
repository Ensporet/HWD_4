package com.Console;

import com.Main;

public class ActionExit implements IAction {


    @Override
    public String getName() {
        return "Exit";
    }


    @Override
    public void action() {
        Main.exit();

    }
}
