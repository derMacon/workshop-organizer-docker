package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.USER_CANT_CREATE_COURSE;

public class UserCantCreateCourseException extends ErrorCodeException {
    public UserCantCreateCourseException() {
        super(USER_CANT_CREATE_COURSE);
    }
}
