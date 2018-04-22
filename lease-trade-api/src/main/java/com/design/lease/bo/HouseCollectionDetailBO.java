package com.design.lease.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HouseCollectionDetailBO implements Serializable{
    private static final long serialVersionUID = 162578507702777103L;

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
