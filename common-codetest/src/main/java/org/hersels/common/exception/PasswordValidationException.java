package org.hersels.common.exception;

public class PasswordValidationException extends Exception {
    private static final long serialVersionUID = 1L;

    public PasswordValidationException(String message) {
        super(message);
    }

    public PasswordValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
