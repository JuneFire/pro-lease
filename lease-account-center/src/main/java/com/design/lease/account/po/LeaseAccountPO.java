/**
 * TODO: complete the comment
 */
package com.design.lease.account.po;

import lombok.Data;

import java.util.Date;

/**
 * TODO: complete the comment
 */
@Data
public class LeaseAccountPO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户UID
     */
    private Long uid;

}