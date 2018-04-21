/**
 * TODO: complete the comment
 */
package com.design.lease.house.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO: complete the comment
 */
@Data
public class LeaseHouseTempPO {

    /**
     * 主键ID
     */
    private Long id;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}