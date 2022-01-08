package com.bagus.findhawker.hawker;


import org.springframework.http.HttpStatus;

public enum ErrorType {

    INVALID_LOCATION("Your location is outside Singapore.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus errorStatus;

    private ErrorType(String message, HttpStatus errorStatus) {
        this.message = message;
        this.errorStatus = errorStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }
}