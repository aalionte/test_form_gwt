package com.upwork.gwt.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.upwork.gwt.client.validator.NameValidator;
import com.upwork.gwt.client.validator.Validator;


public class FormValidation {


    public static boolean isFormValid(TextBox nameInput, ListBox jobSelection, CheckBox terms) {
        errorValidationsHide();
        Boolean isValid = isNameValid(nameInput);
        isValid = isJobValid(jobSelection) && isValid;
        isValid = isTermsAgreed(terms) && isValid;
        return isValid;
    }

    private static boolean isTermsAgreed(CheckBox terms) {
        if (!terms.getValue()) {
            addValidation("check");
            return false;
        }
        return true;
    }

    private static boolean isJobValid(ListBox jobSelection) {
        if (jobSelection.getSelectedValue().length() == 0) {
            jobSelection.getElement().addClassName("selectionError");
            addValidation("fillIn");
            return false;
        }
        return true;
    }

    private static void errorValidationsHide() {
        DOM.getElementById("fillIn").addClassName("hidden");
        DOM.getElementById("check").addClassName("hidden");
        DOM.getElementById("name").removeClassName("selectionError");
        DOM.getElementById("job").removeClassName("selectionError");
    }

    private static void addValidation(String className) {
        DOM.getElementById(className).removeClassName("hidden");
    }

    private static boolean isNameValid(TextBox nameInput) {
        Validator validator = new NameValidator();
        if (!validator.validate(nameInput.getValue())) {
            nameInput.getElement().addClassName("selectionError");
            addValidation("fillIn");
            return false;
        }
        return true;
    }
}
