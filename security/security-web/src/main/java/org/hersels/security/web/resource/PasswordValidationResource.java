package org.hersels.security.web.resource;

import javax.annotation.Resource;

import org.hersels.security.api.IValidationService;
import org.hersels.security.exception.SecurityServiceException;
import org.hersels.security.web.api.ValidatorVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "validator")
public class PasswordValidationResource {

    @Resource
    private IValidationService service;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void validatePassword(@RequestBody ValidatorVO data) throws SecurityServiceException {
        service.validatePassword(data.getPassword());
    }

}
