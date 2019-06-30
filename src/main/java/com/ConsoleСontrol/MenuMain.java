package com.ConsoleСontrol;


import com.Console.ObjectConsoleDefault;


public class MenuMain extends ObjectConsoleDefault {


    public MenuMain() {
        super("Petstore");

        getACTIONS().add(new MenuPet());
        getACTIONS().add(new MenuStore());
        getACTIONS().add(new MenuUser());

        action();
    }


}
