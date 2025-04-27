package org.babi.Exceptions;

public class BidMustBeHigherException extends RuntimeException {
    public BidMustBeHigherException(String message) {
        super(message);
    }
}
