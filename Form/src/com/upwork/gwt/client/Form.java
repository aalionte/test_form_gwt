package com.upwork.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.upwork.gwt.server.gwtServiceImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Form implements EntryPoint {

    /**
     * This is the entry point method.
     */
    final VerticalPanel wrapPanel = new VerticalPanel();
    final VerticalPanel mainFormPanel = new VerticalPanel();
    final Button submitButton = new Button("SEND  \u2192");
    final FormPanel testForm = new FormPanel("Test Form");
    final TextBox nameInput = new TextBox();
    final ListBox jobSelectBox = new ListBox();
    final CheckBox termsCheckBox = new CheckBox();

    public void onModuleLoad() {
        setFormCSSProperties();

        addTitle();

        createForm();

        addRequiredElements();

        submitButton.addClickHandler(event -> {
            if (!FormValidation.isFormValid(nameInput, jobSelectBox, termsCheckBox)) {
                event.preventDefault();
            } else {
                gwtServiceAsync gwtService = (gwtServiceAsync) GWT.create(com.upwork.gwt.client.gwtService.class);
                gwtService.getMessage(nameInput.getValue(), new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Failed to send message");
                    }

                    @Override
                    public void onSuccess(String result) {
                        Window.alert(result);
                    }
                });

            }
        });
    }

    private void setFormCSSProperties() {
        wrapPanel.getElement().setPropertyString("id", "mainPanel");

        mainFormPanel.getElement().setPropertyString("id", "formPanel");
    }

    private void addRequiredElements() {
        mainFormPanel.add(testForm);

        wrapPanel.add(mainFormPanel);

        createErrorContainers();

        RootPanel.get().add(wrapPanel);
    }

    private void addTitle() {
        HTML title = new HTML("<div class='title'>Test Form</div>");
        wrapPanel.add(title);
    }

    private void createErrorContainers() {
        HTML fillInError = new HTML("<div class='error hidden' id='fillIn'>Please fill in all fields<div>");
        HTML checkError = new HTML("<div class='error hidden' id='check'>Please check the checkbox</div");
        VerticalPanel errorPanel = new VerticalPanel();
        errorPanel.add(fillInError);
        errorPanel.add(checkError);
        wrapPanel.add(errorPanel);
    }

    private void createForm() {
        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        testForm.setWidget(panel);

        panel.add(new Label("Name"));
        createTextBox(nameInput);
        panel.add(nameInput);

        createSelectBox(panel);
        panel.add(jobSelectBox);

        createTermsCheckbox();
        panel.add(termsCheckBox);

        panel.add(submitButton);
        testForm.getElement().setPropertyString("id", "testForm");
    }

    private void createTermsCheckbox() {
        termsCheckBox.getElement().setPropertyString("id", "terms");
        termsCheckBox.setText("I agree to send information\n");
    }

    private void createSelectBox(VerticalPanel panel) {
        jobSelectBox.setName("job");
        jobSelectBox.getElement().setPropertyString("id", "job");

        jobSelectBox.addItem("Select a job", "");
        jobSelectBox.addItem("Tinker", "tinker");
        jobSelectBox.addItem("Taylor", "taylor");
        jobSelectBox.addItem("Sailor", "sailor");

        SelectElement selectElement = SelectElement.as(jobSelectBox.getElement());
        OptionElement placeholder = selectElement.getOptions().getItem(0);
        placeholder.setDisabled(true);
        placeholder.setSelected(true);

        panel.add(new Label("Job"));
    }

    private void createTextBox(TextBox nameInput) {
        nameInput.setName("name");
        nameInput.getElement().setPropertyString("id", "name");
        nameInput.getElement().setPropertyString("placeholder", "Enter your name");
    }
}