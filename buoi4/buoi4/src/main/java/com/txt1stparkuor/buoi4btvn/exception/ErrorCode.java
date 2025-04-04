package com.txt1stparkuor.buoi4btvn.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "UNCATEGORIZED_EXCEPTION", HttpStatus.INTERNAL_SERVER_ERROR),
    STUDENT_NOT_EXISTED(404, "Student not existed", HttpStatus.NOT_FOUND),
    CLASSES_NOT_EXISTED(400, "Classes not existed", HttpStatus.NOT_FOUND ),
    HAVING_NULL_FIELD(400, "Must enter all fields with non null value", HttpStatus.BAD_REQUEST)
    ;
    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
