package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.USERNAME_ALREADY_EXISTS;

public class UsernameAlreadyExistsException extends ErrorCodeException {
    public UsernameAlreadyExistsException() {
        super(USERNAME_ALREADY_EXISTS);
    }
}
