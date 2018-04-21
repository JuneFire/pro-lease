package com.design.lease.enums;

public enum DecorateTypeEnum {

    DECORATE_TYPE_REFINED(0,"精装修"),DECORATE_TYPE_ROUGH(1,"毛坯房");

    private int code;

    private String desc;

    DecorateTypeEnum(int code, String desc){
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
