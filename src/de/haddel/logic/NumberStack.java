package de.haddel.logic;

import java.util.EmptyStackException;
import java.util.Stack;

public class NumberStack {

    Stack<Double> NumberStack;


    public NumberStack() {
        NumberStack = new Stack<Double>();
    }

    public void pushStack(double number) {
        NumberStack.push(number);

    }


    public String popStack(){
        return String.valueOf(NumberStack.pop());
    }

    public void addOp() {
        try {
            double first = NumberStack.pop();
            double second = NumberStack.pop();
            NumberStack.push(first + second);
        } catch (EmptyStackException ignored) {

        }
    }

    public void subOp() {
        try {
            double second = NumberStack.pop();
            double first = NumberStack.pop();
            NumberStack.push(first - second);
        } catch (EmptyStackException ignored) {

        }
    }

    public void mulOp() {
        try {
            double first = NumberStack.pop();
            double second = NumberStack.pop();
            NumberStack.push(first * second);
        } catch (EmptyStackException ignored) {

        }
    }

    public void divOp() {
        try {
            double second = NumberStack.pop();
            double first = NumberStack.pop();
            NumberStack.push(first / second);

        } catch (EmptyStackException ignored) {

        }
    }

    public void powerOp() {
        try {
            double second = NumberStack.pop();
            double first = NumberStack.pop();
            double returnValue = first;

            for (int i = 1; i != second; i++)
                returnValue *= first;
            NumberStack.push(returnValue);

        } catch (EmptyStackException ignored) {

        }
    }


    public void resetStack() {
        NumberStack.clear();
    }


}