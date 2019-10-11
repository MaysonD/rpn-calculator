package com.example.rpn.calculator;

import java.util.Collections;
import java.util.Stack;

import static com.example.rpn.checker.MathChecker.isNumber;
import static com.example.rpn.checker.MathChecker.isOperator;

public class RpnCalculator implements Calculator {

    @Override
    public double calculate(Stack<String> expression) {
        Stack<String> expressionCalculations = new Stack<>();
        Collections.reverse(expression);
        while (!expression.empty()) {
            String symbol = expression.pop();
            if (isNumber(symbol)) {
                expressionCalculations.push(symbol);
            } else if (isOperator(symbol)) {
                double operand1 = Double.parseDouble(expressionCalculations.pop());
                double operand2 = Double.parseDouble(expressionCalculations.pop());
                switch (symbol) {
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
}
