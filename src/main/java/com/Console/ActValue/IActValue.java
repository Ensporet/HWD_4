package com.Console.ActValue;

import com.ClassFinder.ClassFinder;
import com.Console.IAction;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Class task to check value formats
 * Expansion of functionality
 *
 * @param <T>
 */
public interface IActValue<T> {

    List<Class> ACTS =
            ClassFinder
                    .find(IAction.class.getPackage().getName())
                    .stream()
                    .filter(aClass -> aClass.getDeclaredAnnotation(Act.class) != null)
                    .collect(Collectors.toList());

    static IActValue getActValue(Class type) {

        for (Class cl : IActValue.ACTS) {
            Act act = (Act) cl.getDeclaredAnnotation(Act.class);
            if (act != null) {
                for (Class types : act.type()) {
                    if (types.equals(type)) {

                        try {
                            return (IActValue) cl.getConstructor().newInstance();
                        } catch (
                                InstantiationException
                                        | IllegalAccessException
                                        | InvocationTargetException
                                        | NoSuchMethodException
                                        e
                        ) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }
            }


        }
        return null;
    }


    String getMassage();

    T isTrueFormat(String string);

    T isTrueFormat(Scanner scanner);


    default String getMassageUpdateFalse() {
        return "Entered value < Not correct format >";
    }

    default String getMassageUpdatedTrue() {
        return null;
    }

    default String getMassageCancel() {
        return ">-----< Cancel >-----<";
    }

    default String getInfoCancel() {
        return (cancelString() == null || cancelString().isEmpty()) ? null : "Cancel : [" + cancelString() + "]";
    }

    default String cancelString() {
        return "x";
    }


}
