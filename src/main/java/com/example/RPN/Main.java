package com.example.RPN;

public class Main {
    public static final String expression = "2 * ( 3 + 4 ) - ( 1 + ( 2 / 2 ) )";
    public static final String reverseExpression = "16 4 3 + - 3 * 21 1 2 + / -";

    public static void main(String[] args) {
        String translate = ReverseNotationTranslator.translate(expression);
        System.out.println(translate);
        System.out.println(ReverseNotationCalculator.calculate(translate));
    }
}
