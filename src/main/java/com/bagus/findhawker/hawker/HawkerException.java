package com.bagus.findhawker.hawker;

public class HawkerException extends RuntimeException {

    private final ErrorType errorType;

    public HawkerException(ErrorType errorType) {
        super();
        this.errorType = errorType;
    }

    public HawkerException(ErrorType errorType, Exception e) {
        super(e);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
