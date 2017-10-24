package com.upwork.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.builder.shared.SelectBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import jdk.internal.util.xml.impl.Input;

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


        //setting the elements of the form
        nameInput.setName("name");
        nameInput.setText("Enter your name");

        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        testForm.setWidget(panel);

        panel.add(new Label("Name"));
        panel.add(nameInput);

        jobSelectBox.setName("job");
        jobSelectBox.addItem("Tinker", "tinker");
        jobSelectBox.addItem("Taylor", "taylor");
        jobSelectBox.addItem("Sailor", "sailor");

        panel.add(new Label("Job"));
        panel.add(jobSelectBox);

        RootPanel.get("submitForm").add(testForm);

        panel.add(new Button("Submit", (ClickEvent event) -> {
            testForm.submit();
        }));

        // Add an event handler to the form.
        testForm.addSubmitHandler(event -> {
            if (nameInput.getText().length() == 0) {
                Window.alert("The text box must not be empty");
                event.cancel();
            }
        });
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
