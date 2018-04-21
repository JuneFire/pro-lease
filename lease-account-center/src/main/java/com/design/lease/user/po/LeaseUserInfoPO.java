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
public class LeaseUserInfoPO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 用户余额
     */
    private Long amount;

    /**
     * 手机号码
     */
    private String iphone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}