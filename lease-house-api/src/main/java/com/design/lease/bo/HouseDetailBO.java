package com.design.lease.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class HouseDetailBO implements Serializable{

    private static final long serialVersionUID = -953060673953423307L;
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
     * 房屋地址
     */
    private String address;

    /**
     * 类型 0 -普通住宅 1 -公寓
     */
    private Integer type;

    /**
     * 户型 0 -单间 1 -一室一厅 2 - 二室一厅 3 -三室一厅 4 - 三室两厅 5 -四室一厅
     */
    private Integer houseType;

    /**
     * 装修 0 -精装修 1 -毛坯房
     */
    private Integer decorate;

    /**
     * 面积
     */
    private BigDecimal area;

    /**
     * 房租 单位是分
     */
    private Long amount;

    /**
     * 0 -押一付一 1 - 押一付三 2 -付一押二
     */
    private Integer payType;

    /**
     * 朝向 0 - 坐北朝南 1 -坐东北朝西南 2 -坐东朝西 3 -坐东南朝西北 4 -坐南朝北 5 -坐西南朝东北
     */
    private Integer orientation;

    /**
     * 0 -初始状态 1 -待审核 2 -审核通过 3 -发布中 4 -已租赁 5 -退房中 6-审核不通过 7 -待发布 8 -已删除
     */
    private Integer status;

    /**
     * 发布时间
     */
    private Date publicTime;

    /**
     * 房屋描述
     */
    private String remark;
}
