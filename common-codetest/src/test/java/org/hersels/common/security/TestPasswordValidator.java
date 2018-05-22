package org.hersels.common.security;

import org.hersels.common.api.IPasswordValidator;

public class TestPasswordValidator implements IPasswordValidator {

    public boolean validate(String text) {
        if (text.isEmpty()) return false;
        return true;
    }

}
