package com.txt1stparkuor.buoi8.exception;

import com.txt1stparkuor.buoi8.base.ResponseUtil;
import com.txt1stparkuor.buoi8.base.RestData;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestData<?>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        System.out.println(ex.getBindingResult());
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseUtil.error(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<RestData<?>> handleDuplicateResourceException(DuplicateResourceException ex) {
        String resolvedMessage = messageSource.getMessage(
                ex.getMessage(),
                ex.getParams(),
                LocaleContextHolder.getLocale()
        );

        return ResponseUtil.error(ex.getStatus(), resolvedMessage);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<RestData<?>> handleUnauthorizedException(UnauthorizedException ex) {
        String message=messageSource.getMessage(
                ex.getMessage(),
                ex.getParams(),
                LocaleContextHolder.getLocale()
        );
        return ResponseUtil.error(ex.getStatus(),message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestData<?>> handleInternalServerError(Exception ex) {
        log.error("An unexpected error occurred: {}", ex.getMessage(), ex);
        String message;
        try {
            message = messageSource.getMessage("exception.general", null, LocaleContextHolder.getLocale());
        } catch (Exception messageEx) {
            log.warn("Could not retrieve general exception message from MessageSource, using default.");
            message = "An unexpected error occurred. Please try again later.";
        }
        return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

}