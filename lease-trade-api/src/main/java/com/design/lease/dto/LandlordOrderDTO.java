package com.design.lease.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LandlordOrderDTO implements Serializable{
    private static final long serialVersionUID = -3539708336339999190L;

    private String orderId;

    private Long uid;

    private Integer status;

}
