package org.hersels.security.exception;

public class SecurityServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private SecurityExceptionType exceptionType;

    public enum SecurityExceptionType {
        ERROR,
        VALIDATION_FAILED;
    }

    public SecurityServiceException(String message, SecurityExceptionType type) {
        super(message);
        this.exceptionType = type;
    }

    public SecurityServiceException(String message, Throwable cause) {
        super(message, cause);
        this.exceptionType = SecurityExceptionType.ERROR;
    }
}
