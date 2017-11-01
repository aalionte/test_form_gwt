package com.upwork.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.upwork.gwt.client.gwtService;

import javax.validation.ConstraintViolationException;

public class gwtServiceImpl extends RemoteServiceServlet implements gwtService {
    // Implementation of sample interface method
    public String getMessage(String msg) throws IllegalArgumentException, ConstraintViolationException {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}