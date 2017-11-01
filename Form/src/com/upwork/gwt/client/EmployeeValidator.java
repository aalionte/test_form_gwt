package com.upwork.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.upwork.gwt.model.Employee;

import javax.validation.Validator;

/**
 * Created by Admin on 29-Oct-17.
 */
public class EmployeeValidator extends AbstractGwtValidatorFactory {


    @GwtValidation(value = {Employee.class})
    public interface GwtValidator extends Validator {
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }
}
