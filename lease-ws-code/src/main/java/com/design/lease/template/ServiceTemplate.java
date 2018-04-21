package com.design.lease.template;

import com.design.lease.ws.bo.Header;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.rpc.constant.RpcCommonConstant;
import com.design.lease.rpc.dto.RpcResponseDTO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServiceTemplate<B, D, R> {

    private static final Logger logger = LoggerFactory.getLogger(ServiceTemplate.class);

    public abstract boolean checkParam(B b);

    public abstract RpcResponseDTO<D> service(Header header, B b);

    public abstract WsResponseMsgVO<R> success(D d);

    public WsResponseMsgVO<R> templateService(Header header, B b) {
        if (checkParam(b)) {
            logger.error("请求接口参数错误.");
            return new WsResponseMsgVO<R>().buildParamErrorResponse();
        }
        RpcResponseDTO<D> d = this.service(header,b);

        if (d != null && StringUtils.equals(RpcCommonConstant.SUCCESS_CODE, d.getCode()) && d.getDate() != null) {
            return success(d.getDate());
        } else {
            return new WsResponseMsgVO<R>().buildUnknownErrorResponse();
        }

    }

}
