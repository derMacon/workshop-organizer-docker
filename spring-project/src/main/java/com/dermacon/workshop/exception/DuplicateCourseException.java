package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.DUPLICATE_COURSE;

public class DuplicateCourseException extends ErrorCodeException {

    public DuplicateCourseException() {
        super(DUPLICATE_COURSE);
    }

}
