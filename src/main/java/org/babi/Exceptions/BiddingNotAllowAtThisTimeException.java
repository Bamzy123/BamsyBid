package org.babi.Exceptions;

public class BiddingNotAllowAtThisTimeException extends RuntimeException {
    public BiddingNotAllowAtThisTimeException(String message) {
        super(message);
    }
}
