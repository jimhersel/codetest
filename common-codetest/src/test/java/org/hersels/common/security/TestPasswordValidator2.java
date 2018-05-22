package org.hersels.common.security;

import org.hersels.common.api.IPasswordValidator;

public class TestPasswordValidator2 implements IPasswordValidator {

    public boolean validate(String text) {
        if (text.contains("123")) return false;
        return true;
    }

}
