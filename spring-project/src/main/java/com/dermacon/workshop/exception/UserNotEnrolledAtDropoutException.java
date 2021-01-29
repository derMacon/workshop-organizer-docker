package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.USER_NOT_ENROLLED_AT_DROPOUT;

public class UserNotEnrolledAtDropoutException extends ErrorCodeException {

    public UserNotEnrolledAtDropoutException() {
        super(USER_NOT_ENROLLED_AT_DROPOUT);
    }

}
