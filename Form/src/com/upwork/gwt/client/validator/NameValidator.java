package com.upwork.gwt.client.validator;


public class NameValidator implements Validator {

    private String nameValidator = "^[a-zA-Z\\s]+";

    @Override
    public boolean validate(String name) {
        if (name.trim().length() == 0 && !name.matches(nameValidator))
            return false;
        return true;
    }
}
