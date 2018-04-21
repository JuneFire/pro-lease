package com.design.lease.ws.exception;

public class WsConfigurationException extends RuntimeException{

    private String message;

    public WsConfigurationException(String message){
        super(message);
    }

    public WsConfigurationException(String message, Throwable cause){
        super(message, cause);
    }

}
