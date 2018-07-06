package ua.tests.task2.controller;

import java.util.Scanner;

/**
 * Used to get input commands from console
 */
public class InputController {

    private final Scanner sc = new Scanner(System.in);

    public String getInput(){
        return sc.nextLine();
    }

}
