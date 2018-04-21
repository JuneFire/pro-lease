package com.design.lease.enums;

public enum PayTypeEnum {

    PAY_TYPE_ONE(0,"押一付一"),PAY_TYPE_TWO(1,"押一付二"),PAY_TYPE_THREE(2,"押一付三");

    private int code;

    private String desc;

    PayTypeEnum(int code, String desc){
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
