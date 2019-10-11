package com.example.rpn.dto;

public class RpnResponse {

    private String expression;
    private String value;

    public RpnResponse() {
    }

    public RpnResponse(String expression, String value) {
        this.expression = expression;
        this.value = value;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
