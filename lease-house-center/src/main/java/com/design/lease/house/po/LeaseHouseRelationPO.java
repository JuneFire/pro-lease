/**
 * TODO: complete the comment
 */
package com.design.lease.house.po;

import lombok.Data;

import java.util.Date;

/**
 * TODO: complete the comment
 */
@Data
public class LeaseHouseRelationPO {

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}