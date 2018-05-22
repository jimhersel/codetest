package org.hersels.security.validator;

import org.hersels.common.api.IPasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class LengthValidator implements IPasswordValidator {

    @Override
    public boolean validate(String text) {
        if (text == null) return false;
        if (text.length() < 5 || text.length() > 12) return false;
        return true;
    }
}
