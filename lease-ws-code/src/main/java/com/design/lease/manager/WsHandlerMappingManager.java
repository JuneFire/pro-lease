package com.design.lease.manager;

import com.design.lease.ws.bo.WsConfig;
import com.design.lease.ws.builder.WsBeanConfigBuilder;

import java.util.HashMap;
import java.util.Map;

public class WsHandlerMappingManager {

    private static WsHandlerMappingManager _ins = new WsHandlerMappingManager();

    private Map<String,WsConfig> handlerMap = new HashMap<String, WsConfig>();

    public static WsHandlerMappingManager getInstance(){
        return _ins;
    }

    private WsHandlerMappingManager(){

    }

    public void init(WsBeanConfigBuilder wsBeanConfigBuilder){
        wsBeanConfigBuilder.initWsConfig();

        for (WsConfig wsConfig : wsBeanConfigBuilder.getWsConfigs()){
            handlerMap.put(wsConfig.getPath(),wsConfig);
        }
    }

    public WsConfig findHandler(String path){
        return handlerMap.get(path);
    }

}
