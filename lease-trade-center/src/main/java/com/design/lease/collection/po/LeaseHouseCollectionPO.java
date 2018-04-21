/**
 * TODO: complete the comment
 */
package com.design.lease.collection.po;

import lombok.Data;

import java.util.Date;

/**
 * TODO: complete the comment
 */
@Data
public class LeaseHouseCollectionPO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 房屋编号
     */
    private String houseNo;

    /**
     * 房屋名称
     */
    private String houseName;

    /**
     * 收藏状态 0- 已收藏 1-已取消收藏
     */
    private Integer status;

    /**
     * 收藏订单号
     */
    private String orderId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}