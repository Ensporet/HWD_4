package com.Console;

import com.Main;


public class ObjectConsoleDefault<T extends IAction> extends ObjectConsole<T> {


    public ObjectConsoleDefault(String NAME) {
        super(
                "Start : " +
                        ((NAME == null)
                                ? ""
                                : NAME)
                        + "...........................................................................................",
                "Exit : "
                        + ((NAME == null)
                        ? "" : NAME)
                        + "...........................................................................................",
                "This command does not exist.",
                NAME
                , Main.SCANNER);

        getDEFAULT_ACTIONS().add(new ActionReturn());
        getDEFAULT_ACTIONS().add(new ActionExit());
    }


}
