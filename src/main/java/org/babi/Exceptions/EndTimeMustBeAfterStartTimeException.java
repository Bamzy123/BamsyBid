package org.babi.Exceptions;

public class EndTimeMustBeAfterStartTimeException extends RuntimeException {
    public EndTimeMustBeAfterStartTimeException(String message) {
        super(message);
    }
}
