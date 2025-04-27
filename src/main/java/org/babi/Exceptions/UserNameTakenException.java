package org.babi.Exceptions;

public class UserNameTakenException extends RuntimeException {
    public UserNameTakenException(String message) {
        super(message);
    }
}
