package com.txt1stparkuor.buoi7.exception;

import com.txt1stparkuor.buoi7.base.ResponseUtil;
import com.txt1stparkuor.buoi7.base.RestData;
import com.txt1stparkuor.buoi7.exception.DuplicateResourceException;
import com.txt1stparkuor.buoi7.exception.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
        log.warn("Validation failed for request body: {}", errors);
        return ResponseUtil.error(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<RestData<?>> handleDuplicateResourceException(DuplicateResourceException ex) {
        String resolvedMessage = messageSource.getMessage(
                ex.getMessage(),
                ex.getParams(),
                LocaleContextHolder.getLocale()
        );

        HttpStatus status = ex.getStatus() != null ? ex.getStatus() : HttpStatus.CONFLICT;
        log.error("DuplicateResourceException: Status={}, Message='{}'", status, resolvedMessage, ex);
        return ResponseUtil.error(status, resolvedMessage);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestData<?>> handleNotFoundException(NotFoundException ex) {
        String resolvedMessage = messageSource.getMessage(
                ex.getMessage(),
                ex.getParams(),
                LocaleContextHolder.getLocale()
        );
        HttpStatus status = ex.getStatus() != null ? ex.getStatus() : HttpStatus.NOT_FOUND;
        log.error("NotFoundException: Status={}, Message='{}'", status, resolvedMessage, ex);
        return ResponseUtil.error(status, resolvedMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
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