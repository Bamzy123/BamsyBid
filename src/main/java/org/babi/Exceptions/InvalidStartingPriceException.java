package org.babi.Exceptions;

public class InvalidStartingPriceException extends RuntimeException {
    public InvalidStartingPriceException(String message) {
        super(message);
    }
}
