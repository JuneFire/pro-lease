package com.design.lease.account.bo;

import java.io.Serializable;

public class AccountDetailBO implements Serializable{

    private static final long serialVersionUID = -2366266176220660630L;

    private Long uid;

    private String uname;

    private Long amount;

    private String iphone;

    private String email;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
