package com.example.basicpost.common.exception;

import com.example.basicpost.common.container.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationIllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SimpleErrorResponse handleValidationIllegalArgumentException() {
        return new SimpleErrorResponse("올바르지 않은 게시글입니다.");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SimpleErrorResponse handleIllegalArgumentException() {
        return new SimpleErrorResponse("존재하지 않는 게시글입니다.");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SimpleErrorResponse handleException()
    {
        return new SimpleErrorResponse("처리되지 않은 예외");
    }
}
