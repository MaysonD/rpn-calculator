package com.example.rpn.service;

import com.example.rpn.converter.RpnCalculator;
import com.example.rpn.dto.Request;
import com.example.rpn.dto.RpnResponse;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class RpnService {

    private RpnCalculator rpnCalculator;

    private Stack<String> convertToRpn(String input) {
        rpnCalculator = new RpnCalculator();
        return rpnCalculator.convert(input);
    }

    private String calculateRpn(Stack<String> expression) {
        rpnCalculator = new RpnCalculator();
        return String.valueOf(rpnCalculator.calculate(expression));
    }

    public RpnResponse calculate(Request request) {
        Stack<String> stack = convertToRpn(request.getInputData());
        String expression = String.join(" ", stack);
        String value = calculateRpn(stack);
        return new RpnResponse(expression, value);
    }
}
