package org.hersels.security.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hersels.common.exception.PasswordValidationException;
import org.hersels.common.security.ValidationManager;
import org.hersels.security.exception.SecurityServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestPasswordValidationService {
    @Mock
    private ValidationManager manager;
    @InjectMocks
    private PasswordValidationService svc;


    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidatePassword_Fail() throws Exception {
        String text = "";
        when(manager.validateText(text)).thenReturn(false);
        try {
            svc.validatePassword(text);
        } catch (SecurityServiceException e) {
            assertTrue("testValidatePassword_Fail invalid message", e.getMessage().contains("Contain lowercase letters and numbers only"));
            verify(manager, new Times(1)).validateText(text);
        }
    }

    @Test(expected = SecurityServiceException.class)
    public void testValidatePassword_NoListeners() throws Exception {
        when(manager.validateText(anyString())).thenThrow(PasswordValidationException.class);
        svc.validatePassword("abc");
        verify(manager, new Times(1)).validateText("abc");
    }

    @Test
    public void testValidatePassword_Valid() throws Exception {
        String text = "abc";
        when(manager.validateText(text)).thenReturn(true);
        svc.validatePassword(text);
    }

}
