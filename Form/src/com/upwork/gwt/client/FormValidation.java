package com.upwork.gwt.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;


/**
 * Created by Admin on 30-Oct-17.
 */
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
        if (nameInput.getValue().trim().length() == 0) {
            nameInput.getElement().addClassName("selectionError");
            addValidation("fillIn");
            return false;
        }
        return true;
    }
}
