/**
 * TODO: complete the comment
 */
package com.design.lease.user.po;

import lombok.Data;

import java.util.Date;

/**
 * TODO: complete the comment
 */
@Data
public class LeaseUserFlowPO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 类型 0 -支付 1- 收入
     */
    private Integer type;

    /**
     * 资金来源或者去向 0 -定金 1-房租 2-押金
     */
    private Integer sourceType;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 状态 0 -初始化 1 -成功 2 -失败
     */
    private Integer status;

    /**
     * 支付订单号
     */
    private String payOrderId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}