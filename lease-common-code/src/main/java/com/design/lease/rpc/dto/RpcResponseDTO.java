package com.design.lease.rpc.dto;

import com.design.lease.rpc.constant.RpcCommonConstant;

import java.io.Serializable;

public class RpcResponseDTO<T> implements Serializable{

    private static final long serialVersionUID = 2888910977272338180L;

    private boolean isSuccess;

    private String code;

    private String msg;

    private boolean missCache;

    private T date;

    public RpcResponseDTO<T> buildSuccessResponse(T t){
        RpcResponseDTO<T> wsResponseMsgVO = new RpcResponseDTO<T>();
        wsResponseMsgVO.setCode(RpcCommonConstant.SUCCESS_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(true);
        wsResponseMsgVO.setMsg(RpcCommonConstant.SUCCESS_DESC);
        wsResponseMsgVO.setDate(t);
        return wsResponseMsgVO;
    }

    public RpcResponseDTO<T> buildSuccessResponse(){
        RpcResponseDTO<T> wsResponseMsgVO = new RpcResponseDTO<T>();
        wsResponseMsgVO.setCode(RpcCommonConstant.SUCCESS_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(true);
        wsResponseMsgVO.setMsg(RpcCommonConstant.SUCCESS_DESC);
        return wsResponseMsgVO;
    }

    public RpcResponseDTO<T> buildParamErrorResponse(){
        RpcResponseDTO<T> wsResponseMsgVO = new RpcResponseDTO<T>();
        wsResponseMsgVO.setCode(RpcCommonConstant.PARAM_ERROR_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(RpcCommonConstant.PARAM_ERROR_DESC);
        return wsResponseMsgVO;
    }

    public RpcResponseDTO<T> buildNotFundErrorResponse(){
        RpcResponseDTO<T> wsResponseMsgVO = new RpcResponseDTO<T>();
        wsResponseMsgVO.setCode(RpcCommonConstant.NOT_FOUND_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(RpcCommonConstant.NOT_FOUND_DESC);
        return wsResponseMsgVO;
    }

    public RpcResponseDTO<T> buildUnknownErrorResponse(){
        RpcResponseDTO<T> wsResponseMsgVO = new RpcResponseDTO<T>();
        wsResponseMsgVO.setCode(RpcCommonConstant.UNKNOWN_ERROR_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(RpcCommonConstant.UNKNOWN_ERROR_DESC);
        return wsResponseMsgVO;
    }

    public RpcResponseDTO<T> buildPermissionErrorResponse(){
        RpcResponseDTO<T> wsResponseMsgVO = new RpcResponseDTO<T>();
        wsResponseMsgVO.setCode(RpcCommonConstant.PERMISSION_ERROR_CODE);
        wsResponseMsgVO.setMissCache(false);
        wsResponseMsgVO.setSuccess(false);
        wsResponseMsgVO.setMsg(RpcCommonConstant.PERMISSION_ERROR_DESC);
        return wsResponseMsgVO;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isMissCache() {
        return missCache;
    }

    public void setMissCache(boolean missCache) {
        this.missCache = missCache;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
