package com.design.lease.account.vo;

import java.io.Serializable;

public class AccountBodyVo implements Serializable{

    private static final long serialVersionUID = -7138067975730675911L;

    private String accountName;

    private String password;

    private Long uid;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
