package org.hersels.security;

import org.hersels.security.service.TestPasswordValidationService;
import org.hersels.security.validator.AllValidatorTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AllValidatorTests.class, TestPasswordValidationService.class})
public class AllServiceTests {

}
