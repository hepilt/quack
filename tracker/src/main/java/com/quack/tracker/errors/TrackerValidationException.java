package com.quack.tracker.errors;

public class TrackerValidationException extends RuntimeException {
    public TrackerValidationException() {
    }

    public TrackerValidationException(String message) {
        super(message);
    }

    public TrackerValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrackerValidationException(Throwable cause) {
        super(cause);
    }

    public TrackerValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}