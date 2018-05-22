package org.hersels.security.web.api;

import java.io.Serializable;

public class ValidatorVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
