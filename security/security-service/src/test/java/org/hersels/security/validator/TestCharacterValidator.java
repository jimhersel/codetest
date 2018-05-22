package org.hersels.security.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestCharacterValidator {

    private CharacterValidator cc;

    @Before
    public void setUp() throws Exception {
        cc = new CharacterValidator();
    }

    @Test
    public void testLowercase_Null() throws Exception {
        assertFalse("testLowerCase_Valid validated null", cc.validate(null));
    }

    @Test
    public void testLowercase_Valid() throws Exception {
        assertTrue("testLowerCase_Valid bad check", cc.validate("abc"));
    }

    @Test
    public void testLowercase_Invalid() throws Exception {
        assertFalse("testLowerCase_Invalid didnt fail", cc.validate("Abc"));
    }

    @Test
    public void testLowercase_InvalidSpecial() throws Exception {
        assertFalse("testLowerCase_InvalidSpecial didnt fail", cc.validate("ab.c"));
    }

    @Test
    public void testNumeric_Valid() throws Exception {
        assertTrue("testNumeric bad check", cc.validate("123"));
    }

    @Test
    public void testNumeric_Invalid() throws Exception {
        assertFalse("testNumeric_Invalid didnt fail", cc.validate("123~4"));
    }
}
