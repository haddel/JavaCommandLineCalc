package de.haddel.main;

import de.haddel.logic.Logic;

public class Main {

    public static void main(String[] arguments){

        if (arguments.length == 1) {
            Logic logic = new Logic();
            System.out.println("Result: " + logic.evaluate(arguments[0]));
        }
        else
            System.out.println("other arguments expected");
    }


}
