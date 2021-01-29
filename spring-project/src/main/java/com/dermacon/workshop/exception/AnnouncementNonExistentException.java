package com.dermacon.workshop.exception;

import static com.dermacon.workshop.exception.ErrorCode.ANNOUNCEMENT_NONEXISTENT;

public class AnnouncementNonExistentException extends ErrorCodeException {
    public AnnouncementNonExistentException() {
        super(ANNOUNCEMENT_NONEXISTENT);
    }
}
