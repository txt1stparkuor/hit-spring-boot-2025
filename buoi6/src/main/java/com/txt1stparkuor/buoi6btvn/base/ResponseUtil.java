package com.txt1stparkuor.buoi6btvn.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<RestData<?>> success(Object data) {
        return success(HttpStatus.OK, data);
    }
    public static ResponseEntity<RestData<?>> success(HttpStatus status) {
        return success(status,null);
    }

    public static ResponseEntity<RestData<?>> success(HttpStatus status, Object data) {
        RestData<?> response = new RestData<>(data);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<RestData<?>> error(HttpStatus status, Object message) {
        RestData<?> response = RestData.error(message);
        return new ResponseEntity<>(response, status);
    }

}