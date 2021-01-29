package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.USER_ALREADY_ENROLLED;

public class UserAlreadyEnrolledException extends ErrorCodeException {

    public UserAlreadyEnrolledException() {
        super(USER_ALREADY_ENROLLED);
    }

}
