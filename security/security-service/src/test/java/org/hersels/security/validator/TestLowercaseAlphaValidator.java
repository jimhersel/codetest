package org.hersels.security.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestLowercaseAlphaValidator {

    private LowercaseAlphaValidator v = new LowercaseAlphaValidator();

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidate_Null() throws Exception {
        assertFalse("testValidate_Null validated", v.validate(null));
    }

    @Test
    public void testValidate_OneAlpha() throws Exception {
        assertTrue("testValidate_OneAlpha not validated", v.validate("a"));
    }

    @Test
    public void testValidate_MultipleAlpha() throws Exception {
        assertTrue("testValidate_MultipleAlpha not validated", v.validate("a1bAcccD3"));
    }

    @Test
    public void testValidate_OneAlphaOneNumber() throws Exception {
        assertTrue("testValidate_OneAlphaOneNumber not validated alpha", v.validate("a1"));
        assertTrue("testValidate_OneAlphaOneNumber not validated number", v.validate("1a"));
    }

    @Test
    public void testValidate_NoLowercase() throws Exception {
        assertFalse("testValidate_NoAlpha validated", v.validate("A1."));
    }

    @Test
    public void testValidate_Numbers() throws Exception {
        assertFalse("testValidate_Numbers validated", v.validate("1234"));
    }

}
