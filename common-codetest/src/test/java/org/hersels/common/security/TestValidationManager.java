package org.hersels.common.security;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestValidationManager {

    @InjectMocks
    private ValidationManager validationManager;


    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidateText_Valid() throws Exception {
        String text = "valid12text";
        assertTrue("testValidateText_Valid did not validate", validationManager.validateText(text));
    }

    @Test
    public void testValidateText_Invalid123() throws Exception {
        String text = "valid123text";
        assertFalse("testValidateText_Invalid123 validated", validationManager.validateText(text));
    }

    @Test
    public void testValidateText_Invalid() throws Exception {
        String text = "";
        assertFalse("testValidateText_Invalid did validate", validationManager.validateText(text));
    }

}
