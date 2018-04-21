package com.design.lease.ws.dto;

import com.design.lease.ws.constant.WsResultConstant;
import lombok.Data;

import java.io.Serializable;

@Data
public class WsResponseMsgVO<T> extends WsResponseVO implements Serializable{

    private static final long serialVersionUID = -8193451585282072643L;

    public T message;

    public WsResponseMsgVO<T> buildSuccessResponse(T t){
        WsResponseMsgVO<T> wsResponseMsgVO = new WsResponseMsgVO<T>();
        wsResponseMsgVO.setCode(WsResultConstant.SUCCESS_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(true);
        wsResponseMsgVO.setMsg(WsResultConstant.SUCCESS_DESC);
        wsResponseMsgVO.setMessage(t);
        return wsResponseMsgVO;
    }

    public WsResponseMsgVO<T> buildSuccessResponse(){
        WsResponseMsgVO<T> wsResponseMsgVO = new WsResponseMsgVO<T>();
        wsResponseMsgVO.setCode(WsResultConstant.SUCCESS_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(true);
        wsResponseMsgVO.setMsg(WsResultConstant.SUCCESS_DESC);
        return wsResponseMsgVO;
    }

    public WsResponseMsgVO<T> buildParamErrorResponse(){
        WsResponseMsgVO<T> wsResponseMsgVO = new WsResponseMsgVO<T>();
        wsResponseMsgVO.setMessage(null);
        wsResponseMsgVO.setCode(WsResultConstant.PARAM_ERROR_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(WsResultConstant.PARAM_ERROR_DESC);
        return wsResponseMsgVO;
    }

    public WsResponseMsgVO<T> buildNotFundErrorResponse(){
        WsResponseMsgVO<T> wsResponseMsgVO = new WsResponseMsgVO<T>();
        wsResponseMsgVO.setMessage(null);
        wsResponseMsgVO.setCode(WsResultConstant.NOT_FOUND_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(WsResultConstant.NOT_FOUND_DESC);
        return wsResponseMsgVO;
    }

    public WsResponseMsgVO<T> buildUnknownErrorResponse(){
        WsResponseMsgVO<T> wsResponseMsgVO = new WsResponseMsgVO<T>();
        wsResponseMsgVO.setMessage(null);
        wsResponseMsgVO.setCode(WsResultConstant.UNKNOWN_ERROR_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(WsResultConstant.UNKNOWN_ERROR_DESC);
        return wsResponseMsgVO;
    }

    public WsResponseMsgVO<T> buildUnknownErrorResponse(String desc){
        WsResponseMsgVO<T> wsResponseMsgVO = new WsResponseMsgVO<T>();
        wsResponseMsgVO.setMessage(null);
        wsResponseMsgVO.setCode(WsResultConstant.UNKNOWN_ERROR_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(desc);
        return wsResponseMsgVO;
    }


    public WsResponseMsgVO<T> buildPermissionErrorResponse(){
        WsResponseMsgVO<T> wsResponseMsgVO = new WsResponseMsgVO<T>();
        wsResponseMsgVO.setMessage(null);
        wsResponseMsgVO.setCode(WsResultConstant.PERMISSION_ERROR_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(WsResultConstant.PERMISSION_ERROR_DESC);
        return wsResponseMsgVO;
    }

}
