package org.hersels.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hersels.common.api.IPasswordValidator;
import org.hersels.common.exception.PasswordValidationException;
import org.reflections.Reflections;

public class ValidationListenerScanner {
    private static final Logger LOGGER = LogManager.getLogger();

    private Collection<IPasswordValidator> listeners;
    private String packageName;

    public ValidationListenerScanner(String packageName) throws PasswordValidationException {
        listeners = new ArrayList<IPasswordValidator>();
        this.packageName = packageName;
        init();
    }

    public Collection<IPasswordValidator> getListeners() {
        return listeners;
    }

    private void init() throws PasswordValidationException {
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends IPasswordValidator>> classes = reflections.getSubTypesOf(IPasswordValidator.class);

        if (classes != null && !classes.isEmpty()) {
            for (Class<? extends IPasswordValidator> c : classes) {
                try {
                    listeners.add(c.newInstance());
                } catch (IllegalAccessException e) {
                    String msg = "Error creating class: " + c.getName() + " -- " + e.getMessage();
                    LOGGER.error(msg);
                    throw new PasswordValidationException(msg);
                } catch (InstantiationException e) {
                    String msg = "Error creating class: " + c.getName() + " -- " + e.getMessage();
                    LOGGER.error(msg);
                    throw new PasswordValidationException(msg);
                }
            }
        } else {
            LOGGER.error("No validation listeners have been defined");
            throw new PasswordValidationException("No validation listeners have been defined");
        }
    }
}
