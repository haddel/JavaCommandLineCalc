package de.haddel.logic;

import java.util.Stack;

public class OperatorStack {
    Stack<String> OperatorStack;
    int priority;
    Stack<Integer> priorityStack;

    public OperatorStack() {
        OperatorStack = new Stack<String>();
        priorityStack = new Stack<Integer>();

        priority = 0;

    }

    public void pushStack(String input) {

        if (checkInput(input)) {
            OperatorStack.push(input);
            setPriority(input);
        }

    }

    public String peekStack() {
        return OperatorStack.peek();
    }

    public String popStack() {
        priority--;

        if (OperatorStack.size() == 1)
            priority = 0;

        return OperatorStack.pop();
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(String input) {

        if (input.equals("+"))
            priority = 1;
        if (input.equals("-"))
            priority = 1;
        if (input.equals("*"))
            priority = 2;
        if (input.equals("/"))
            priority = 2;
        if (input.equals("^"))
            priority = 3;
        if (input.equals("(")) {
            priorityStack.push(priority);
            priority = 0;
        }
    }

    public boolean checkInput(String input) {

        return input.length() == 1
                && (input.equals("+")
                || input.equals("-")
                || input.equals("*")
                || input.equals("/")
                || input.equals("^")
                || input.equals("("));
    }

    public boolean isStackEmpty() {
        return OperatorStack.isEmpty();
    }


    public void loadPriorityFromStack() {
        priority = priorityStack.pop();
    }

    public void resetStack() {
        priority = 0;
        OperatorStack.clear();
    }
}

