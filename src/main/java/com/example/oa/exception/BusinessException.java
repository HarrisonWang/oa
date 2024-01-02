package com.example.oa.exception;

public abstract class BusinessException extends RuntimeException {

    private ErrorCode code;

    BusinessException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

}
