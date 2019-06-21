package com;


import com.Console.ConsoleDefault;
import com.Console.IAction;
import com.HttpResponse.HttpResponse;
import com.HttpResponse.MethodResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String URI = "http://petstore.swagger.io/";
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final HttpResponse RESPONSE = new HttpResponse();
    public static final String SEPARATOR =
            "=========================================================================================================";

    public static void main(String[] args) {

        System.out.println(">-------< Start HWD_4 >-------<");

        ConsoleDefault consoleDefault = new ConsoleDefault(Main.SCANNER) {
            @Override
            public String getName() {
                return "Main menu";
            }
        };
        consoleDefault.getACTIONS().addAll(Main.actions());
        consoleDefault.action();

        Main.exit();

    }


    public static List<IAction> actions() {
        List<IAction> list = new ArrayList<>();

        for (Method method : Main.RESPONSE.getClass().getMethods()) {
            MethodResponse methodResponse = method.getDeclaredAnnotation(MethodResponse.class);
            if (methodResponse == null) {
                continue;
            }

            method.setAccessible(true);
            list.add(new IAction() {
                @Override
                public String getName() {
                    return (methodResponse.name().isEmpty()) ? method.getName() : methodResponse.name();
                }

                @Override
                public void action() {
                    try {
                        System.out.println(SEPARATOR);
                        method.invoke(Main.RESPONSE);
                        System.out.println(SEPARATOR);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return list;
    }


    public static void exit() {
        System.out.println("Close HWD_4");
        Main.SCANNER.close();
        System.exit(0);
    }


}
