package com.design.lease.house.vo;

import java.io.Serializable;

public class HouseBodyVo implements Serializable{

    private static final long serialVersionUID = 1050886669691163239L;

    private String houseNo;

    private String houseName;

    private Integer status;

    private HouseFilterVo[] filter;

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

    public HouseFilterVo[] getFilter() {
        return filter;
    }

    public void setFilter(HouseFilterVo[] filter) {
        this.filter = filter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
