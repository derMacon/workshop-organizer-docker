package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.NON_EXISTENT_COURSE;

public class NonExistentCourseException extends ErrorCodeException {

    public NonExistentCourseException() {
        super(NON_EXISTENT_COURSE);
    }

}
