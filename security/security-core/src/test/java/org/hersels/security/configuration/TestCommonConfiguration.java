package org.hersels.security.configuration;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.hersels.common.exception.PasswordValidationException;
import org.hersels.common.security.ValidationManager;
import org.hersels.security.TestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
@TestPropertySource("classpath:config/application-test.properties")
public class TestCommonConfiguration {

    @Resource
    ValidationManager manager;

    @Before
    public void setUp() throws Exception {}

    @Test(expected = PasswordValidationException.class)
    public void testValidationManagerConfig() throws Exception {
        assertNotNull("testValidationManagerConfig null manager", manager);
        // should throw exception since there are not validators in core
        boolean b = manager.validateText(null);
    }

}
