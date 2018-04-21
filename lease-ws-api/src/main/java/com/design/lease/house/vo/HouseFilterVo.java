package com.design.lease.house.vo;

import java.io.Serializable;

public class HouseFilterVo implements Serializable{
    private static final long serialVersionUID = 262750546416303859L;

    private Integer type;

    private Integer houseType;

    private Integer amountRange;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getAmountRange() {
        return amountRange;
    }

    public void setAmountRange(Integer amountRange) {
        this.amountRange = amountRange;
    }
}
