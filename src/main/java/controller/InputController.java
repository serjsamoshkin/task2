package controller;

import java.util.Scanner;

/**
 * Used to get input commands
 */
public class InputController {

    private final Scanner sc = new Scanner(System.in);

    public String getInput(){
        return sc.nextLine();
    }

}
