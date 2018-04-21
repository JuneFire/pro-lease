/**
 * TODO: complete the comment
 */
package com.design.lease.pay.po;

import lombok.Data;

import java.util.Date;

/**
 * TODO: complete the comment
 */
@Data
public class LeasePayFlowPO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 租客uid
     */
    private Long tenantUid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 房屋编号
     */
    private String houseNo;

    /**
     * 房屋名称
     */
    private String houseName;

    /**
     * 支付订单号
     */
    private String payOrderId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}