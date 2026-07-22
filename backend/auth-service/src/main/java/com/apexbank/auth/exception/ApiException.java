package com.apexbank.auth.exception;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }

}