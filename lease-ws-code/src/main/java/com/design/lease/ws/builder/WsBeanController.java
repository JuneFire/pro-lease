package com.design.lease.ws.builder;

import com.design.lease.ws.bo.WsConfig;
import com.design.lease.ws.exception.WsConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class WsBeanController{

    private static final Logger logger = LoggerFactory.getLogger(WsBeanController.class.getName());

    @Autowired
    private WsBeanConfigBuilder wsBeanConfigBuilder;

    private Map<String,WsConfig> wsConfigMap = new HashMap<String, WsConfig>();

    public void initWsConfig(){

        for (WsConfig wsConfig : wsBeanConfigBuilder.getWsConfigs()){
            wsConfigMap.put(wsConfig.getPath(),wsConfig);
        }
    }

    public WsConfig findWsConfig(String path) throws WsConfigurationException{
        WsConfig wsConfig = wsConfigMap.get(path);
        if (wsConfig == null) {
            logger.info("找不到对应服务");
            throw new WsConfigurationException("找不到对应服务");
        }
        return wsConfig;
    }

    public void setWsBeanConfigBuilder(WsBeanConfigBuilder wsBeanConfigBuilder) {
        this.wsBeanConfigBuilder = wsBeanConfigBuilder;
    }
}
