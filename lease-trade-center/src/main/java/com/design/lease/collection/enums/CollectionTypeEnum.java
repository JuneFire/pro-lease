package com.design.lease.collection.enums;

public enum CollectionTypeEnum {

    COLLECTION_TYPE_success(0,"已收藏"),COLLECTION_TYPE_CANCEL(1,"取消收藏");

    private int code;

    private String desc;

    CollectionTypeEnum(int code,String desc){
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
