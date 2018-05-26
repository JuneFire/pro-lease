package com.lease.design.cmd.context;

import com.lease.design.cmd.manager.CmdManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CmdContextLoaderListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(CmdContextLoaderListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            CmdManager.init();
        } catch (Exception e) {
            logger.error("初始化context异常.",e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
