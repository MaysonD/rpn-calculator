package com.example.rpn.service;

import com.example.rpn.calculator.Calculator;
import com.example.rpn.calculator.RpnCalculator;
import com.example.rpn.converter.Converter;
import com.example.rpn.converter.RpnConverter;
import com.example.rpn.dto.Request;
import com.example.rpn.dto.RpnResponse;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class RpnService {

    private Stack<String> convertToRpn(String input) {
        Converter rpnConverter = new RpnConverter();
        return rpnConverter.convert(input);
    }

    private String calculateRpn(Stack<String> expression) {
        Calculator rpnCalculator = new RpnCalculator();
        return String.valueOf(rpnCalculator.calculate(expression));
    }

    public RpnResponse calculate(Request request) {
        Stack<String> stack = convertToRpn(request.getInputData());
        String expression = String.join(" ", stack);
        String value = calculateRpn(stack);
        return new RpnResponse(expression, value);
    }
}
