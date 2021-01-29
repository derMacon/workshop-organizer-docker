package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.HOST_ENROLL_OWN_COURSE;

public class HostEnrollOwnCourseException extends ErrorCodeException {

    public HostEnrollOwnCourseException() {
        super(HOST_ENROLL_OWN_COURSE);
    }

}
