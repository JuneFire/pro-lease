package com.design.lease.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HouseCollectionDTO implements Serializable{
    private static final long serialVersionUID = -5993323714699716339L;

    private String orderId;

    private String houseNo;

    private Long uid;

    private Integer status;

}
