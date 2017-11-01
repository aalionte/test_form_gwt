package com.upwork.gwt.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;


/**
 * Created by Admin on 30-Oct-17.
 */
public class ButtonAction implements ClickHandler {

    @Override
    public void onClick(ClickEvent event) {
        errorValidationsHide();
        validateName();
    }

    private void errorValidationsHide() {

    }

    private void validateName() {
        String nameValue = DOM.getElementById("name").getAttribute("value");
        if (nameValue.length() == 0) {
            Window.alert(nameValue);
        } else {
            Window.alert("Sss");
        }
    }
}
