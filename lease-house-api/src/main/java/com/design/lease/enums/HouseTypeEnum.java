package com.design.lease.enums;

public enum HouseTypeEnum {

    HOUSE_TYPE_SING(0,"单间"),HOUSE_TYPE_ONE_BEDROOM(1,"一室一厅"),
    HOUSE_TYPE_TWO_BEDROOM(2,"两室一厅"),HOUSE_TYPE_THREE_BEDROOM(3,"三室一厅");

    private int code;

    private String desc;

    HouseTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
