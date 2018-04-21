package com.design.lease.servlet;

import com.design.lease.ws.exception.WsConfigurationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WsHandlerAdapter {

    public void doHandler(HttpServletRequest request, HttpServletResponse response) throws WsConfigurationException;

}
