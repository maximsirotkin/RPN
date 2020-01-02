package com.example.RPN;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseNotationTranslator {

    private Deque<String> stack = new LinkedList<>();
    private String expression;
    private String inputSeparator;
    private String outputSeparator;
    private StringBuilder output = new StringBuilder();

    private ReverseNotationTranslator(String expression, String inputSeparator, String outputSeparator) {
        this.expression = expression;
        this.inputSeparator = inputSeparator;
        this.outputSeparator = outputSeparator;
    }

    public static String translate(String expression) {
        return translate(expression, " ", " ");
    }

    public static String translate(String expression, String inputSeparator, String outputSeparator) {
        return new ReverseNotationTranslator(expression, inputSeparator, outputSeparator).translate();
    }

    private String translate() {
        String[] array = this.expression.split(this.inputSeparator);
        for (String element : array) {
            if ("(".equals(element)) {
                this.stack.push(element);
            } else if (")".equals(element)) {
                while (!this.stack.isEmpty()) {
                    String tmp = this.stack.pop();
                    if ("(".equals(tmp)) {
                        break;
                    }
                    this.append(tmp);
                }
            } else if (this.isOperand(element)) {
                this.append(element);
            } else {
                while (!this.stack.isEmpty()) {
                    String tmp = this.stack.pop();
                    if ("(".equals(tmp)) {
                        this.stack.push(tmp);
                        break;
                    }
                    this.append(tmp);
                }
                this.stack.push(element);
            }
        }
        while (!this.stack.isEmpty()) {
            this.append(this.stack.pop());
        }
        return this.output.toString();
    }

    private void append(String str) {
        if (this.output.length() > 0) {
            this.output.append(this.outputSeparator);
        }
        this.output.append(str);
    }

    private boolean isOperand(String element) {
        return !"+".equals(element)
                && ! "-".equals(element)
                && !"*".equals(element)
                && !"/".equals(element)
                && !"(".equals(element)
                && !")".equals(element);
    }

    private boolean isHighPriorityOperator(String operator) {
        return "*".equals(operator) || "/".equals(operator);
    }
}
