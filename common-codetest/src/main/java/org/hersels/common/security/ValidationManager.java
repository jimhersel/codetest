package org.hersels.common.security;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hersels.common.api.IPasswordValidator;
import org.hersels.common.exception.PasswordValidationException;

public class ValidationManager {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SYNC_LOCK = "ValidationManagerLock";

    private String packageName;
    private ValidationListenerScanner scanner = null;

    public ValidationManager(String packageName) {
        this.packageName = packageName;
    }

    /**
     * Delivers the validation based on all the registered validators from the consumer.
     *
     * @param revision
     */
    public boolean validateText(String text) throws PasswordValidationException {
        Collection<IPasswordValidator> listeners = getListeners();

        if (listeners != null && !listeners.isEmpty()) {
            for (IPasswordValidator listener : listeners) {
                if (listener != null) {
                    if (!listener.validate(text)) return false;
                }
            }
        } else {
            LOGGER.error("Password validation not possible as there are no registered validators");
            return false;
        }
        return true;
    }

    private Collection<IPasswordValidator> getListeners() throws PasswordValidationException {
        synchronized (SYNC_LOCK) {
            if (scanner == null) {
                scanner = new ValidationListenerScanner(packageName);
            }
        }
        return scanner.getListeners();
    }
}
