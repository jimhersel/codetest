package org.hersels.security.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestLengthValidator {

    private LengthValidator validator = new LengthValidator();

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidate_Null() throws Exception {
        assertFalse("testValidate_Null validated", validator.validate(null));
    }

    @Test
    public void testValidate_ValidLength() throws Exception {
        assertTrue("testValidate_ValidLength did not validate 5", validator.validate("abc12"));
        assertTrue("testValidate_ValidLength did not validate 6", validator.validate("123abc"));
        assertTrue("testValidate_ValidLength did not validate 12", validator.validate("123abcdef456"));
    }

    @Test
    public void testValidate_InvalidLength() throws Exception {
        assertFalse("testValidate_InvalidLength validated 1", validator.validate("a"));
        assertFalse("testValidate_InvalidLength validated alpha/number", validator.validate("a2"));
        assertFalse("testValidate_InvalidLength validated 14", validator.validate("abcdef123456./"));
    }

}
