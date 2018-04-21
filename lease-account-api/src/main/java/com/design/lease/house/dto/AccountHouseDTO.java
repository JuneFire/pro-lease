package com.design.lease.house.dto;

import java.io.Serializable;

public class AccountHouseDTO implements Serializable{

    private static final long serialVersionUID = 14831901765489672L;

    private Long uid;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
