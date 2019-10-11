package com.example.rpn.unit.calculator;

import com.example.rpn.calculator.Calculator;
import com.example.rpn.calculator.RpnCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RpnCalculatorTest {

    private Calculator rpnCalculator = new RpnCalculator();

    @Test
    public void successConvertTest() {
        Stack<String> stack = new Stack<>();
        String s = "2 3 6 * + 8 1 1 + / +";
        for (String temp : Arrays.asList(s))
            stack.push(temp);
        double rpnValue = rpnCalculator.calculate(stack);
        assertEquals(24, Integer.parseInt(String.valueOf(rpnValue)));
    }
}
