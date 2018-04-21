package com.design.lease.servlet;

import com.design.lease.ws.bo.WsConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WsDispatcherSevlet {
    public WsConfig findHandler(HttpServletRequest request, HttpServletResponse response);
}
