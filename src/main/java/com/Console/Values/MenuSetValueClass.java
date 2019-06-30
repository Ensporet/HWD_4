package com.Console.Values;

import com.Console.ActValue.IActValue;
import com.Console.IAction;
import com.Console.ObjectConsole;
import com.Console.ObjectConsoleDefault;

import java.beans.Transient;
import java.lang.reflect.Field;

public class MenuSetValueClass extends ObjectConsoleDefault {

    private Object object;


    public MenuSetValueClass(String NAME, Object obj) {
        super(NAME);
        this.object = obj;

        action();
    }


    @Override
    protected void update() {
        updateActions();
        super.update();
    }

    protected void updateActions() {
        getACTIONS().clear();


        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.getAnnotation(Transient.class) == null) {
                IAction action = createAction(field);
                if (action == null) {
                    continue;
                }
                getACTIONS().add(action);
            }
        }

    }


    protected IAction createAction(Field field) {
        field.setAccessible(true);

        IActValue actValue = IActValue.getActValue(field.getType());

        return (actValue == null) ? null : new IAction() {
            @Override
            public String getName() {
                return
                        field.getName() + " : " +
                                getValue(field) + " " +
                                field.getType();
            }

            @Override
            public void action() {

                Object obj = actValue.isTrueFormat(getScanner());
                if (obj != null) {
                    setValue(field, obj);
                    ObjectConsole.ConsoleUpdate = true;
                }

            }
        };
    }

    private Object getValue(Field field) {
        try {
            return field.get(getObject());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setValue(Field field, Object newValue) {
        try {
            field.set(getObject(), newValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
