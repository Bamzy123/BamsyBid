package org.babi.Exceptions;

public class UserIsBannedException extends RuntimeException {
    public UserIsBannedException(String message) {
        super(message);
    }
}
