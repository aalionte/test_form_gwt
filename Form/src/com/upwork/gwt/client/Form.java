package com.upwork.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.upwork.gwt.model.Employee;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Form implements EntryPoint {

    /**
     * This is the entry point method.
     */

    private final gwtServiceAsync gwtService = GWT.create(gwtService.class);

    public void onModuleLoad() {
        Employee employee = new Employee();
        ValidationView validationView = new ValidationView(employee, gwtService);
        RootPanel.get().add(validationView);
    }
}



