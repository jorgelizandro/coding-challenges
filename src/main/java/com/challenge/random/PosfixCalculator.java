package com.challenge.random;

import com.challenge.easy.Factorial;

import java.util.Stack;

public class PosfixCalculator {
    private PosfixCalculator() {

    }

    public static long getResult(String posfixOperation) {
        String[] items = posfixOperation.split(" ");

        Stack<Integer> valuesStack = new Stack<>();
        for (String item: items) {
            try {
                valuesStack.push(Integer.parseInt(item));
            } catch (NumberFormatException e) {
                int value1;
                int value2;
                switch (item) {
                    case "+":
                        value2 = valuesStack.pop();
                        value1 = valuesStack.pop();
                        valuesStack.push(value1 + value2);
                        break;
                    case "-":
                        value2 = valuesStack.pop();
                        value1 = valuesStack.pop();
                        valuesStack.push(value1 - value2);
                        break;
                    case  "*":
                        value2 = valuesStack.pop();
                        value1 = valuesStack.pop();
                        valuesStack.push(value1 * value2);
                        break;
                    case "/":
                        value2 = valuesStack.pop();
                        value1 = valuesStack.pop();
                        valuesStack.push(value1 / value2);
                        break;
                    case "!":
                        value1 = valuesStack.pop();
                        valuesStack.push(Factorial.getFactorial(value1));
                        break;
                    default:
                        throw new UnsupportedOperationException("Unsupported operator: " + item);
                }
            }
        }

        return valuesStack.pop();
    }

    public static void main(final String... args) {
        System.out.println(getResult("1 2 + 2 + !"));   //120
        System.out.println(getResult("1 0 1 / + !"));   //120
    }
}
