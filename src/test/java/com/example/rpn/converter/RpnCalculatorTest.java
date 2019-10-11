package com.example.rpn.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RpnCalculatorTest {

    private Calculator rpnCalculator = new RpnCalculator();

    @Test
    public void convert() {
        String rpnExpression = String.join(" ", rpnCalculator.convert("2+3*6+8/(1+1)"));
        assertEquals("2 3 6 * + 8 1 1 + / +", rpnExpression);
    }
}
