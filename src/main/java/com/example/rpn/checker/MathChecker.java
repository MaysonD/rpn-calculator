package com.example.rpn.checker;

public class MathChecker {

    private static final String[] OPERATORS = {"+", "-", "/", "*"};

    public static boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException exc) {
            return false;
        }
        return true;
    }

    public static boolean isOperator(String string) {
        for (String operator : OPERATORS)
            if (operator.equals(string))
                return true;
        return false;
    }

    public static boolean isLeftBracket(String symbol) {
        return symbol.equals("(");
    }

    public static boolean isRightBracket(String symbol) {
        return symbol.equals(")");
    }

    public static int definePriority(String operation) {
        if (operation.equals("+") || operation.equals("-"))
            return 0;
        else
            return 1;
    }
}
