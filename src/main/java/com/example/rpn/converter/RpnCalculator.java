package com.example.rpn.converter;

import java.util.Collections;
import java.util.Stack;

public class RpnCalculator implements Calculator {

    private final String[] OPERATORS = {"+", "-", "/", "*"};
    private Stack<String> operations = new Stack<>();
    private Stack<String> rpnExpression = new Stack<>();

    private Stack<String> expressionCalculations = new Stack<>();

    @Override
    public double calculate(Stack<String> expression) {
        Collections.reverse(expression);
        expressionCalculations.clear();
        while (!expression.empty()) {
            String token = expression.pop();
            if (isNumber(token)) {
                expressionCalculations.push(token);
            } else if (isOperator(token)) {
                double operand1 = Double.parseDouble(expressionCalculations.pop());
                double operand2 = Double.parseDouble(expressionCalculations.pop());
                switch (token) {
                    case "*":
                        expressionCalculations.push(String.valueOf(operand2 * operand1));
                        break;
                    case "/":
                        expressionCalculations.push(String.valueOf(operand2 / operand1));
                        break;
                    case "+":
                        expressionCalculations.push(String.valueOf(operand2 + operand1));
                        break;
                    case "-":
                        expressionCalculations.push(String.valueOf(operand2 - operand1));
                        break;

                }
            }
        }
        return Double.parseDouble(expressionCalculations.pop());
    }

    @Override
    public Stack<String> convert(String inputData) {
        String[] symbols = inputData.replaceAll("\\s+", "").split("");
        for (String symbol : symbols) {
            if (isNumber(symbol)) {
                rpnExpression.push(symbol);
            } else if (isOperator(symbol)) {
                while (!operations.empty()
                        && isOperator(operations.lastElement())
                        && (definePriority(symbol)
                        <= definePriority(operations.lastElement()))) {
                    rpnExpression.push(operations.pop());
                }
                operations.push(symbol);
            } else if (isLeftBracket(symbol)) {
                operations.push(symbol);
            } else if (isRightBracket(symbol)) {
                while (!operations.empty()
                        && !isLeftBracket(operations.lastElement())) {
                    rpnExpression.push(operations.pop());
                }
                operations.pop();
            } else {
                operations.clear();
                rpnExpression.clear();
                throw new NumberFormatException("Unexpected item!");
            }
        }
        while (!operations.empty()) {
            rpnExpression.push(operations.pop());
        }
        return rpnExpression;
    }

    private boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
        } catch (Exception exc) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String string) {
        for (String operator : OPERATORS)
            if (operator.equals(string))
                return true;
        return false;
    }

    private boolean isLeftBracket(String symbol) {
        return symbol.equals("(");
    }

    private boolean isRightBracket(String symbol) {
        return symbol.equals(")");
    }

    private int definePriority(String operation) {
        if (operation.equals("+") || operation.equals("-"))
            return 0;
        else
            return 1;
    }
}
