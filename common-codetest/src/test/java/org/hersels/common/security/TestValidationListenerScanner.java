package org.hersels.common.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.hersels.common.api.IPasswordValidator;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("rawtypes")
public class TestValidationListenerScanner {

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testValidationListenerScanner() throws Exception {
        Class c = this.getClass();
        Package pkg = c.getPackage();
        ValidationListenerScanner scanner = new ValidationListenerScanner(pkg.getName());
        Collection<IPasswordValidator> listeners = scanner.getListeners();
        assertNotNull("testValidationListenerScanner null listener collection", listeners);
        assertEquals("testValidationListenerScanner invalid listener count", 2, listeners.size());
        for (IPasswordValidator p : listeners) {
            assertTrue("testValidationListenerScanner invalid listener", (p instanceof TestPasswordValidator) || (p instanceof TestPasswordValidator2));
        }
    }
}
