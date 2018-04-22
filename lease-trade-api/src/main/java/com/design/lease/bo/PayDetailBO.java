package com.design.lease.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayDetailBO implements Serializable{
    private static final long serialVersionUID = 3555731893216617234L;

    /**
     * 支付编号
     */
    private String payOrderId;
}
