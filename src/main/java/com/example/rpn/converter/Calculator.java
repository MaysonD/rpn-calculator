package com.example.rpn.converter;

import java.util.Stack;

public interface Calculator {

    Stack<String> convert(String inputData);

    double calculate(Stack<String> expression);
}
