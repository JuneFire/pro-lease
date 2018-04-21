package com.design.lease.ws.servlet;

import com.design.lease.manager.WsHandlerMappingManager;
import com.design.lease.ws.builder.WsBeanConfigBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WsConfigServletContext implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        WsBeanConfigBuilder wsBeanConfigBuilder = (WsBeanConfigBuilder) webApplicationContext.getBean("wsBeanConfigBuilder");
        WsHandlerMappingManager wsHandlerMappingManager = WsHandlerMappingManager.getInstance();
        wsHandlerMappingManager.init(wsBeanConfigBuilder);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
