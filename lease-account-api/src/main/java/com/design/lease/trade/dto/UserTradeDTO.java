package com.design.lease.trade.dto;

import java.io.Serializable;

public class UserTradeDTO implements Serializable{

    private static final long serialVersionUID = -2408279337639791468L;

    private Long uid;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
