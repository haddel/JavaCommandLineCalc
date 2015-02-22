package de.haddel.logic;

public class Logic {

    NumberStack numberStack;
    OperatorStack operatorStack;
    String[] inputSplit;


    public Logic() {
        numberStack = new NumberStack();
        operatorStack = new OperatorStack();
    }

    public String evaluate(String input) {


        inputSplit = splitInput(input);

        numberStack.resetStack();
        operatorStack.resetStack();

        for (int count = 0; count <= inputSplit.length - 1; count++) {


            if (inputSplit[count].matches("[0-9.En]*")) {


                if (inputSplit[count].contains("n"))
                    inputSplit[count] = inputSplit[count].replaceAll("n", "-");

                if (!inputSplit[count].isEmpty())
                    numberStack.pushStack(Double.parseDouble(inputSplit[count]));

            } else if (inputSplit[count].matches("[\\+\\-\\*/\\^\\(\\)]*")) {
                if (inputSplit[count].equals("+")) {

                    if (operatorStack.getPriority() < 1) {
                        operatorStack.pushStack(inputSplit[count]);
                    } else if (operatorStack.getPriority() >= 1) {

                        calculate(operatorStack.popStack());
                        count--;

                    }


                } else if (inputSplit[count].equals("-")) {

                    if (operatorStack.getPriority() < 1) {
                        operatorStack.pushStack(inputSplit[count]);
                    } else if (operatorStack.getPriority() >= 1) {

                        calculate(operatorStack.popStack());
                        count--;
                    }
                } else if (inputSplit[count].equals("*")) {

                    if (operatorStack.getPriority() < 2) {
                        operatorStack.pushStack(inputSplit[count]);
                    } else if (operatorStack.getPriority() >= 2) {

                        calculate(operatorStack.popStack());
                        count--;

                    }
                } else if (inputSplit[count].equals("/")) {

                    if (operatorStack.getPriority() < 2) {
                        operatorStack.pushStack(inputSplit[count]);
                    } else if (operatorStack.getPriority() >= 2) {

                        calculate(operatorStack.popStack());
                        count--;

                    }
                } else if (inputSplit[count].equals("^")) {

                    if (operatorStack.getPriority() < 3) {
                        operatorStack.pushStack(inputSplit[count]);
                    } else if (operatorStack.getPriority() >= 3) {

                        calculate(operatorStack.popStack());
                        count--;
                    }
                } else if (inputSplit[count].equals("(")) {

                    operatorStack.pushStack(inputSplit[count]);


                } else if (inputSplit[count].equals(")")) {

                    while (!operatorStack.peekStack().equals("(")) {
                        calculate(operatorStack.popStack());
                    }

                    operatorStack.loadPriorityFromStack();

                }
            }
        }


        while (!operatorStack.isStackEmpty()) {
            calculate(operatorStack.popStack());
        }

        return numberStack.popStack();
    }


    private void calculate(String operator) {

        if (operator.equals("+"))
            numberStack.addOp();
        else if (operator.equals("-"))
            numberStack.subOp();
        else if (operator.equals("*"))
            numberStack.mulOp();
        else if (operator.equals("/"))
            numberStack.divOp();
        else if (operator.equals("^"))
            numberStack.powerOp();
    }


    private String[] splitInput(String input) {
        String[] tmpArray;

        if (input.contains(" "))
            input = input.replaceAll(" ", "");

        if (input.contains(","))
            input = input.replaceAll("\\,", ".");
        if (input.contains(".."))
            input = input.replaceAll("..", ".");

        if (input.contains("++"))
            input = input.replaceAll("\\+\\+", "+");
        if (input.contains("*+"))
            input = input.replaceAll("\\*\\+" , "*");
        if (input.contains("/+"))
            input = input.replaceAll("/\\+" , "/");

        if (input.contains("("))
            input = input.replaceAll("\\*\\*", "*");
        if (input.contains("("))
            input = input.replaceAll("//", "/");

        if (input.contains("(("))
            input = input.replaceAll("\\(\\(", "(1*(");

        if (input.startsWith("-"))
            input = input.replaceFirst("\\-", "n");
        if (input.contains("("))
            input = input.replaceAll("\\(", "('");
        if (input.contains("+-"))
            input = input.replaceAll("\\+\\-", "+n");
        if (input.contains("--"))
            input = input.replaceAll("\\-\\-", "+");
        if (input.contains("*-"))
            input = input.replaceAll("\\*\\-", "*n");
        if (input.contains("/-"))
            input = input.replaceAll("/\\-", "/n");


        if (input.contains("+"))
            input = input.replaceAll("\\+", "'\\+'");
        if (input.contains("-"))
            input = input.replaceAll("\\-", "'\\-'");
        if (input.contains("*"))
            input = input.replaceAll("\\*", "'\\*'");
        if (input.contains("/"))
            input = input.replaceAll("/", "'/'");
        if (input.contains("^"))
            input = input.replaceAll("\\^", "'\\^'");


        if (input.contains(")"))
            input = input.replaceAll("\\)", "')");


        tmpArray = input.split("'");

        return tmpArray;
    }
}