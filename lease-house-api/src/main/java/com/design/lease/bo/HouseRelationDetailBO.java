package com.design.lease.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HouseRelationDetailBO implements Serializable{

    private static final long serialVersionUID = 1605115861453694998L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 房屋编号
     */
    private String houseNo;

    /**
     * 房东uid
     */
    private Long landlordUid;

    /**
     * 房东手机号
     */
    private String iphone;

    /**
     * 房东名称
     */
    private String landlordName;

}
