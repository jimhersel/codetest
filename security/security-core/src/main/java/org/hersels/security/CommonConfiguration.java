package org.hersels.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hersels.common.security.ValidationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {
    private static Logger logger = LogManager.getLogger();

    private static String PACKAGE_NAME = "org.hersels.security.validator";

    @Bean
    public ValidationManager validationManagerConfig() {
        logger.info("ValidationManager bean starting");
        ValidationManager manager = new ValidationManager(PACKAGE_NAME);
        logger.info("ValidationManager bean started");
        return manager;
    }
}
