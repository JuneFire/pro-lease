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
public class LeaseHouseImgPO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 房屋编号
     */
    private String houseNo;

    /**
     * 房屋图片url
     */
    private String houseImgUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}