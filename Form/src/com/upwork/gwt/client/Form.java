package com.upwork.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.builder.shared.SelectBuilder;
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
        final TextBox name = new TextBox();
        final ListBox jobBox = new ListBox();



/*        button.addClickHandler(event -> {
            if (label.getText().equals("")) {
                gwtService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
            } else {
                label.setText("");
            }
        });
*/
        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        mainPanel.add(name);
        mainPanel.add(jobBox);
        mainPanel.add(submitButton);

        RootPanel.get("submitForm").add(mainPanel);

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
