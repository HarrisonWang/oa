package com.example.oa.exception;

class ErrorMessage {

    private int status;

    private ErrorCode code;

    ErrorMessage(Integer status, ErrorCode code) {
        this.status = status;
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public ErrorCode getCode() {
        return code;
    }
}