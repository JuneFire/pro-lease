package com.design.lease.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountDto implements Serializable{

    private static final long serialVersionUID = -8760851208800176571L;

    private String accountName;

    private String password;

    private Long uid;

}
