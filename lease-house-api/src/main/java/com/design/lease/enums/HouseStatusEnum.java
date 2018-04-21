package com.design.lease.enums;

public enum HouseStatusEnum {

    STATUS_INIT(0,"初始化"),STATUS_AUDIT_WAIT(1,"待审核"),STATUS_AUDIT_SUCCESS(2,"审核通过"),
    STATUS_PUB(3,"发布中"),STATUS_END(4,"已租赁"),STATUS_EXIT(5,"退房中"),
    STATUS_AUDIT_fail(6,"审核失败"),STATUS_PUB_WAIT(7,"待发布"),STATUS_DETEL(8,"已删除");

    private int code;

    private String desc;

    HouseStatusEnum(int code, String desc){
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
