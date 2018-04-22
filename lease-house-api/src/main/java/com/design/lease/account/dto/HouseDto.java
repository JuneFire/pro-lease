package com.design.lease.account.dto;

import java.io.Serializable;

public class HouseDto implements Serializable{

    private static final long serialVersionUID = 377007836349249332L;

    private String houseNo;

    private String houseName;

    private Integer status;

    private Long uid;

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
