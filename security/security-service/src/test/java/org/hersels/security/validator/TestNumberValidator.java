package org.hersels.security.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestNumberValidator {

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidate_OneNumber() throws Exception {
        NumberValidator v = new NumberValidator();
        assertTrue("testValidate_OneNumber not validated", v.validate("4"));
    }

    @Test
    public void testValidate_MultipleNumbers() throws Exception {
        NumberValidator v = new NumberValidator();
        assertTrue("testValidate_MultipleNumbers not validated", v.validate("455668"));
    }

    @Test
    public void testValidate_NumbersAndAlpha() throws Exception {
        NumberValidator v = new NumberValidator();
        assertTrue("testValidate_NumbersAndAlpha not validated", v.validate("a4b5c5.6d6e8G"));
    }

    @Test
    public void testValidate_NoNumbers() throws Exception {
        NumberValidator v = new NumberValidator();
        assertFalse("testValidate_NoNumbers not validated", v.validate("abc.deG"));
    }

    @Test
    public void testValidate_Null() throws Exception {
        NumberValidator v = new NumberValidator();
        assertFalse("testValidate_Null validated", v.validate(null));
    }
}
