package com.design.lease.ws.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class WsResponseVO implements Serializable{

    private static final long serialVersionUID = 7798704475424395951L;

    public boolean isSuccess;

    public String code;

    public String msg;

    public boolean missCache;

}
