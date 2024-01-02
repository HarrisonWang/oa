package com.example.oa.exception;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(ErrorCode code, String message) {
        super(code, message);
    }

}
