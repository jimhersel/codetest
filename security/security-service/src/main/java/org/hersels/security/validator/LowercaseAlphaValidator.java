package org.hersels.security.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hersels.common.api.IPasswordValidator;
import org.springframework.stereotype.Component;

@Component
public class LowercaseAlphaValidator implements IPasswordValidator {

    @Override
    public boolean validate(String text) {
        if (text == null) return false;
        Pattern p = Pattern.compile("^(.*[a-z]++.*)$");
        Matcher m = p.matcher(text);

        return m.matches();
    }

}
