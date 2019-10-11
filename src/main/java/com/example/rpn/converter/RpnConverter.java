package com.example.rpn.converter;

import java.util.Stack;

import static com.example.rpn.checker.MathChecker.*;

public class RpnConverter implements Converter {

    @Override
    public Stack<String> convert(String inputData) {
        Stack<String> operations = new Stack<>();
        Stack<String> rpnExpression = new Stack<>();
        //TODO create better parse mechanism
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
}
