package com.example.basicpost.common.container;

public class SimpleErrorResponse {

    private String message;

    public SimpleErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
