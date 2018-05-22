package org.hersels.security.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hersels.common.exception.PasswordValidationException;
import org.hersels.common.security.ValidationManager;
import org.hersels.security.api.IValidationService;
import org.hersels.security.exception.SecurityServiceException;
import org.hersels.security.exception.SecurityServiceException.SecurityExceptionType;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidationService implements IValidationService {
    private static Logger logger = LogManager.getLogger();
    private static String PASSWORD_ERROR = "Passwords must:\n\t1) Contain lowercase letters and numbers only\n\t2) Be between 5 and 12 characters in length;\n\t3) Cannot contain the same sequence of characters repeated;";

    // • Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
    // • Must be between 5 and 12 characters in length.
    // • Must not contain any sequence of characters immediately followed by the same sequence.

    @Resource
    private ValidationManager manager;

    @Override
    public void validatePassword(String text) throws SecurityServiceException {
        try {
            if (!manager.validateText(text)) {
                throw new SecurityServiceException(PASSWORD_ERROR, SecurityExceptionType.VALIDATION_FAILED);
            }
        } catch (PasswordValidationException e) {
            logger.error("Error during password validation.", e);
            throw new SecurityServiceException("Error during validation", e);
        }
    }
}
