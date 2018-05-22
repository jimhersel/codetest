package org.hersels.security.api;

import org.hersels.security.exception.SecurityServiceException;

public interface IValidationService {

    /**
     * Password validator.
     * 
     * @param text
     * @throws SecurityServiceException
     */
    public void validatePassword(String text) throws SecurityServiceException;

}
