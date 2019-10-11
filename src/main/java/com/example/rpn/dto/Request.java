package com.example.rpn.dto;

public class Request {

    private String inputData;

    public Request(String inputData) {
        this.inputData = inputData;
    }

    public Request() {
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }
}
