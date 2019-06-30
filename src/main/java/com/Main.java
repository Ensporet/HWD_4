package com;


import com.ConsoleСontrol.MenuMain;

import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {

        new MenuMain();

        exit();
    }


    public static void exit() {
        System.out.println("Exit : System");
        Main.SCANNER.close();
        System.exit(0);
    }
}
