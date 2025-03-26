package com.txt1stparkuor.buoi3btvn.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception exception) {
        return "error";
    }
}
