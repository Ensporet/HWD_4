package com.Console.Values;

import com.Console.ActValue.IActValue;
import com.Console.IAction;

import java.util.Scanner;


public class ActionSetValuePrimitive implements IAction {

    private final Class TYPE;
    private final Scanner SCANNER;
    private final String NAME;
    private Object value;


    public ActionSetValuePrimitive(Class type, Object value, Scanner scanner, String name) {
        this.TYPE = type;
        this.value = value;
        this.SCANNER = scanner;
        this.NAME = name;
    }


    @Override
    public String getName() {
        return (NAME == null) ? getTYPE().getTypeName() : NAME;
    }

    @Override
    public void action() {

        Object obj = IActValue.getActValue(getTYPE()).isTrueFormat(getSCANNER());
        if (obj != null) {
            setValue(obj);
        }
    }

    public Scanner getSCANNER() {
        return SCANNER;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Class getTYPE() {
        return TYPE;
    }
}
