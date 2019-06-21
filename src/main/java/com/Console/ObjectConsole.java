package com.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class ObjectConsole<T> implements IAction {

    private final HashMap<String, T> hashMap = new HashMap();
    private String startMessage;
    private String endMessage;
    private String notHaveCommandMessage;
    public static int ConsoleIteration = 0;
    public static boolean ConsoleUpdate = false;
    private final List<IAction> DEFAULT_ACTIONS = new ArrayList<>();
    private final List<IAction> ACTIONS = new ArrayList<>();
    private String info;
    private Scanner scanner;


    public ObjectConsole(String startMessage, String endMessage, String notHaveCommandMessage, Scanner scanner) {
        this.startMessage = startMessage;
        this.endMessage = endMessage;
        this.notHaveCommandMessage = notHaveCommandMessage;
        this.scanner = scanner;
    }

    public ObjectConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public void action() {

        printlnString(getStartMessage());

        ObjectConsole.ConsoleUpdate = true;
        ObjectConsole.ConsoleIteration++;
        while (ObjectConsole.ConsoleIteration > 0) {
            if (ObjectConsole.ConsoleUpdate) {
                update();
            }

            System.out.println(getInfo());

            Object obj = getHashMap().get(scanner.nextLine());
            if (obj == null) {
                printlnString(getNotHaveCommandMessage());
            } else {
                if (obj instanceof IAction) {
                    ((IAction) obj).action();
                }
            }


        }
        ObjectConsole.ConsoleIteration++;
        printlnString(getEndMessage());

    }


    //------------------------------------------

    private void update() {
        ObjectConsole.ConsoleUpdate = false;
        getHashMap().clear();
        int iteration = 0;
        StringBuilder stringBuilder = new StringBuilder((getName() == null) ? "Console\n" : getName() + " : \n");


        for (IAction action : getACTIONS()) {
            String key = String.valueOf(iteration++);
            getHashMap().put(key, action);
            stringBuilder.append("\n" + createRowInfo(key, action));
        }

        stringBuilder.append("\n" + getSeparator());

        for (IAction action : getDEFAULT_ACTIONS()) {
            String key = String.valueOf(iteration++);
            getHashMap().put(key, action);
            stringBuilder.append("\n" + createRowInfo(key, action));
        }

        setInfo(stringBuilder.toString());

    }

    protected String getSeparator() {
        return "|----------------------------------------------------------------------------------|";
    }

    private String createRowInfo(String key, IAction action) {

        return "[" + ((key == null) ? "NULL" : key) + "] : " + ((action.getName() == null) ? "NULL" : action.getName());

    }

    //--------------------------------------------
    private void printlnString(String s) {
        if (s != null) {
            System.out.println(s);
        }
    }

    public HashMap getHashMap() {
        return hashMap;
    }


    public String getStartMessage() {
        return startMessage;
    }

    public void setStartMessage(String startMessage) {
        this.startMessage = startMessage;
    }

    public String getEndMessage() {
        return endMessage;
    }

    public void setEndMessage(String endMessage) {
        this.endMessage = endMessage;
    }

    public List<IAction> getDEFAULT_ACTIONS() {
        return DEFAULT_ACTIONS;
    }

    public List<IAction> getACTIONS() {
        return ACTIONS;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getNotHaveCommandMessage() {
        return notHaveCommandMessage;
    }

    public void setNotHaveCommandMessage(String notHaveCommandMessage) {
        this.notHaveCommandMessage = notHaveCommandMessage;
    }
}
