package com.design.lease.servlet.impl;

import com.design.lease.manager.WsHandlerMappingManager;
import com.design.lease.servlet.WsDispatcherSevlet;
import com.design.lease.ws.bo.WsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class WsDispatcherServletImpl implements WsDispatcherSevlet{

    private static final Logger logger = LoggerFactory.getLogger(WsDispatcherSevlet.class);

    public WsConfig findHandler(HttpServletRequest request, HttpServletResponse response) {
        setHttpServletRequest(request);
        String path = request.getRequestURI();
        logger.info("path = {}",path);
        WsHandlerMappingManager wsHandlerMappingManager = WsHandlerMappingManager.getInstance();
        return wsHandlerMappingManager.findHandler(path);
    }

    private void setHttpServletRequest(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



}
