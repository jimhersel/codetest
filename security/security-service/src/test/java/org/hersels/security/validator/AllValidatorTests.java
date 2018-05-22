package org.hersels.security.validator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        TestCharacterValidator.class,
        TestLowercaseAlphaValidator.class,
        TestNumberValidator.class,
        TestLengthValidator.class})
public class AllValidatorTests {

}
