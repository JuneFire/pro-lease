/**
 * TODO: complete the comment
 */
package com.design.lease.landlord.po;

import lombok.Data;

import java.util.Date;

/**
 * TODO: complete the comment
 */
@Data
public class LeaseLandlordDetailPO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 房东uid
     */
    private Long landlordUid;

    /**
     * 租客uid
     */
    private Long tenantUid;

    /**
     * 房屋编号
     */
    private String houseNo;

    /**
     * 期数
     */
    private Integer period;

    /**
     * 0 -初始状态 1 -已付定金 2 -已入住 3 -已到期
     */
    private Integer status;

    /**
     *  0 -初始状态 1 -未结清 2 -已结清
     */
    private Integer amountStatus;

    /**
     * 应缴总金额
     */
    private Long totalAmount;

    /**
     * 剩余金额
     */
    private Long remainAmount;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 租赁订单号
     */
    private String landlordOrderId;

    /**
     * 房租到期日
     */
    private Date endDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}