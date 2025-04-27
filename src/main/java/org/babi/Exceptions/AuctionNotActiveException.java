package org.babi.Exceptions;

public class AuctionNotActiveException extends RuntimeException {
    public AuctionNotActiveException(String message) {
        super(message);
    }
}
