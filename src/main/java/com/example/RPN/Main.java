package com.example.RPN;

public class Main {

    public static final String expression = "16 4 3 + - 3 * 1 2 + -";

    public static void main(String[] args) {
        System.out.println(ReverseNotationCalculator.calculate(expression));
    }
}
