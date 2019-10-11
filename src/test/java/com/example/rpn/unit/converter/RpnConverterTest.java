package com.example.rpn.unit.converter;


import com.example.rpn.converter.Converter;
import com.example.rpn.converter.RpnConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class RpnConverterTest {

    private Converter rpnConverter = new RpnConverter();

    @Test
    public void successConvertTest() {
        String rpnExpression = String.join(" ", rpnConverter.convert("2+3*6+8/(1+1)"));
        assertEquals("2 3 6 * + 8 1 1 + / +", rpnExpression);
    }

    @Test
    public void invalidExpressionConvertTest() {
        try {
            String.join(" ", rpnConverter.convert("a+3*6+8/(b+1)"));
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            fail();
        }
    }
}
