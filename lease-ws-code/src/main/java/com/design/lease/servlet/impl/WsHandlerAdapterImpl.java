package com.design.lease.servlet.impl;

import com.design.lease.manager.WsHandlerMappingManager;
import com.design.lease.servlet.WsHandlerAdapter;
import com.design.lease.ws.bo.WsConfig;
import com.design.lease.ws.builder.WsBeanInvokeBuilder;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.ws.exception.WsConfigurationException;
import com.design.lease.ws.utils.WsResponseUtils;
import com.design.lease.utils.JacksonObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class WsHandlerAdapterImpl implements WsHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WsHandlerAdapter.class);

    private WsBeanInvokeBuilder wsBeanInvokeBuilder;

    public void doHandler(HttpServletRequest request, HttpServletResponse response) throws WsConfigurationException {
        setHttpServletRequest(request);
        String path = request.getRequestURI();
        logger.info("path = {}",path);
        String params = getParam(request);
        WsConfig wsConfig = getWsConfig(path);
        WsResponseMsgVO wsResponseMsgVO = wsBeanInvokeBuilder.invoke(params,wsConfig);
        WsResponseUtils.sendMessage(response, JacksonObjectUtils.jacksonObjectToSerializable(wsResponseMsgVO));
    }

    private void setHttpServletRequest(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String getParam(HttpServletRequest request){
        String params = request.getParameter("params");
        if(StringUtils.isEmpty(params)){
            params = "{\"head\":{},\"body\":{}}";
        }
        return params;
    }

    private WsConfig getWsConfig(String path) throws WsConfigurationException{
        WsConfig wsConfig = WsHandlerMappingManager.getInstance().findHandler(path);
        if ( wsConfig == null){
            throw new WsConfigurationException("找不到对应wsConfig");
        }
        return wsConfig;
    }

    public void setWsBeanInvokeBuilder(WsBeanInvokeBuilder wsBeanInvokeBuilder) {
        this.wsBeanInvokeBuilder = wsBeanInvokeBuilder;
    }
}
