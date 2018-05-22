package org.hersels.security.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestCharacterSequenceValidator {

    CharacterSequenceValidator validator = new CharacterSequenceValidator();

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidate_Null() throws Exception {
        assertTrue("testValidate_Null did not validate", validator.validate(null));
    }

    @Test
    public void testValidate_blanks() throws Exception {
        assertTrue("testValidate_blanks did not validate empty string", validator.validate(""));
        assertTrue("testValidate_blanks did not validate one blank", validator.validate(" "));
        assertFalse("testValidate_blanks did validate multiple blank", validator.validate("  "));
    }

    @Test
    public void testValidate_OneCharacter() throws Exception {
        assertTrue("testValidate_OneCharacter did not validate", validator.validate("a"));
    }

    @Test
    public void testValidate_TwoCharacters() throws Exception {
        assertTrue("testValidate_TwoCharacters did not validate", validator.validate("ab"));
        assertFalse("testValidate_TwoCharacters did validate seq", validator.validate("aa"));
        assertFalse("testValidate_TwoCharacters did validate seq numbers", validator.validate("99"));
    }

    @Test
    public void testValidate_OddStringLength() throws Exception {
        assertTrue("testValidate_OddStringLength did not validate", validator.validate("ab123ab"));
        assertFalse("testValidate_OddStringLength did validate seq", validator.validate("ab1212c"));
        assertFalse("testValidate_OddStringLength did validate seq two", validator.validate("34cdAbAbA.7"));
    }

    @Test
    public void testValidate_EvenStringLength() throws Exception {
        assertTrue("testValidate_EvenStringLength did not validate", validator.validate("ab13cdecd"));
        assertFalse("testValidate_EvenStringLength did validate seq", validator.validate("ab12charchar"));
        assertFalse("testValidate_EvenStringLength did validate seq two", validator.validate("34cdAbAbA7"));
    }

    @Test
    public void testValidate_FullStringCompare() throws Exception {
        assertTrue("testValidate_FullStringCompare did not validate", validator.validate("ab12cd.ab12cd"));
        assertFalse("testValidate_FullStringCompare did validate seq", validator.validate("ab12cdab12cd"));
    }

}
