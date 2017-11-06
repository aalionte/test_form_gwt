package com.upwork.gwt.server;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.upwork.gwt.client.gwtService;

import javax.validation.ConstraintViolationException;

@RemoteServiceRelativePath("gwtService")
public class gwtServiceImpl extends RemoteServiceServlet implements gwtService {
    // Implementation of sample interface method
    public String getMessage(String msg) throws IllegalArgumentException, ConstraintViolationException {
        return "Welcome, " + msg;
    }
}