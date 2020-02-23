package com.example.basicpost.common.exception;

import org.springframework.validation.Errors;

public class ValidationIllegalArgumentException extends IllegalArgumentException {

    private Errors errors;

    public ValidationIllegalArgumentException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
