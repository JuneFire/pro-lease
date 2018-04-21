package com.design.lease.ws.builder;

import com.design.lease.ws.bo.WsConfig;
import com.design.lease.ws.dto.WsResponseMsgVO;

public interface WsBeanInvoke {

    public WsResponseMsgVO invoke(String param, WsConfig wsConfig);

}
