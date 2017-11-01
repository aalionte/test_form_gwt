package com.upwork.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import javax.validation.ConstraintViolationException;

@RemoteServiceRelativePath("gwtService")
public interface gwtService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg) throws IllegalArgumentException, ConstraintViolationException;


    public static class App {
        private static gwtServiceAsync ourInstance = GWT.create(gwtService.class);

        public static synchronized gwtServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
