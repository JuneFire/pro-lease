package com.design.lease.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayDetailDTO implements Serializable{

    private static final long serialVersionUID = -7170621792677660330L;

    private String orderId;

    private Long uid;

    private String houseNo;

}
