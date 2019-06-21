package com.Console;

import java.util.Scanner;

public class ConsoleDefault extends ObjectConsole<IAction> {


    public static void main(String[] args) {

        ConsoleDefault consoleDefault = new ConsoleDefault(new Scanner(System.in));
        consoleDefault.getACTIONS().add(new ActionDefault());
        consoleDefault.getACTIONS().add(new ActionDefault());
        consoleDefault.getACTIONS().add(new ActionDefault());
        consoleDefault.action();

    }


    public ConsoleDefault(Scanner scanner) {
        super("............................................................................................",
                ".........................................................................................",
                "This command does not exist.", scanner);

        getDEFAULT_ACTIONS().add(new ActionReturn());
        getDEFAULT_ACTIONS().add(new ActionExit());
    }

    @Override
    public String getName() {
        return null;
    }


}
