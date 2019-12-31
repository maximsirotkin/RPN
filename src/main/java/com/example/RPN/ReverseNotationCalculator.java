package com.example.RPN;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseNotationCalculator {

    public static int calculate(String expression) {
        return calculate(expression, " ");
    }

    public static int calculate(String expression, String separator) {
        String[] array = expression.split(separator);
        Deque<Integer> stack = new LinkedList<>();
        for (String element : array) {
            if (isOperator(element)) {
                stack.push(calculate(element, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(element));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String element) {
        return "+".equals(element)
                || "-".equals(element)
                || "*".equals(element)
                || "/".equals(element);
    }

    private static int calculate(String operator, Integer a, Integer b) {
        switch (operator) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
            default:
                return 0;
        }
    }
}
