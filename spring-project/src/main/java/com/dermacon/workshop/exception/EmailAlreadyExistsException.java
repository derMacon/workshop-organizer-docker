package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.EMAIL_ALREADY_EXISTS;

public class EmailAlreadyExistsException extends ErrorCodeException {
    public EmailAlreadyExistsException() {
        super(EMAIL_ALREADY_EXISTS);
    }
}
