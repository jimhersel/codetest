package org.hersels.common.api;

public interface IPasswordValidator {

    /**
     * Definition of the validator interface to be implemented by consumer
     * 
     * @param text
     * @return
     */
    public boolean validate(String text);

}
