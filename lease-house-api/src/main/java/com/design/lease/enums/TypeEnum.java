package com.design.lease.enums;

public enum TypeEnum {

    TYPE_ordinary(0,"普通住宅"),TYPE_LOFT(1,"公寓");

    private int code;

    private String desc;

    TypeEnum(int code,String desc){
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
