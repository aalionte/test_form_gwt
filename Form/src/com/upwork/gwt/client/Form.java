package com.upwork.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.*;
import com.upwork.gwt.client.validator.ButtonAction;


/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Form implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final VerticalPanel mainPanel = new VerticalPanel();
        final Button submitButton = new Button("Send");
        final FormPanel testForm = new FormPanel("Test Form");
        final TextBox nameInput = new TextBox();
        final ListBox jobSelectBox = new ListBox();
        final CheckBox termsCheckBox = new CheckBox();

        //setting the elements of the form
        nameInput.setName("name");
        nameInput.getElement().setPropertyString("id", "name");
        nameInput.getElement().setPropertyString("placeholder", "Enter your name");

        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        testForm.setWidget(panel);

        panel.add(new Label("Name"));
        panel.add(nameInput);

        jobSelectBox.setName("job");
        jobSelectBox.getElement().setPropertyString("id", "job");

        jobSelectBox.addItem("Job", "");
        jobSelectBox.addItem("Tinker", "tinker");
        jobSelectBox.addItem("Taylor", "taylor");
        jobSelectBox.addItem("Sailor", "sailor");

        panel.add(new Label("Job"));
        panel.add(jobSelectBox);

        termsCheckBox.getElement().setPropertyString("id", "terms");
        termsCheckBox.setText("I agree to send information\n");
        panel.add(termsCheckBox);

        panel.add(submitButton);
        mainPanel.getElement().setPropertyString("id", "mainPanel");

        testForm.getElement().setPropertyString("id", "testForm");
//        mainPanel.add(new DivElement().setInnerHTML("Test Form"));
        mainPanel.add(testForm);

        RootPanel.get().add(mainPanel);

        submitButton.addClickHandler(new ButtonAction());
    }
}



